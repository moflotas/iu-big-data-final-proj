"""
Train and evaluate Linear Regression Model and GBTRegressor Model
"""

import os
import math
import numpy as np
from pyspark.sql import SparkSession, DataFrame
import pyspark.sql.functions as F
from pyspark.ml import Pipeline, Transformer
from pyspark.ml.feature import StringIndexer, OneHotEncoder, VectorAssembler, Word2Vec, Tokenizer
from pyspark import keyword_only
from pyspark.ml.param.shared import HasInputCol, HasOutputCol, Param, Params, TypeConverters
from pyspark.ml.util import DefaultParamsReadable, DefaultParamsWritable
from pyspark.sql.types import IntegerType
from pyspark.ml.regression import LinearRegression, GBTRegressor
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator


# Connect to Hive
TEAM = "team21"
DB_NAME = f"{TEAM}_projectdb"
TABLE_NAME = "car_prices_part_buck"

# location of Hive database in HDFS
WAREHOUSE = "project/hive/warehouse"

spark = SparkSession.builder\
    .appName(f"{TEAM} - spark ML")\
    .master("yarn")\
    .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
    .config("spark.sql.warehouse.dir", WAREHOUSE)\
    .config("spark.sql.avro.compression.codec", "snappy")\
    .enableHiveSupport()\
    .getOrCreate()

sc = spark.sparkContext


# Specify the input and output features
# We will use the following features
# Excluded 'vin' because it is like an ID of a car
# Excluded 'mmr' because we want to make our own estimate of price
# 'saledate' will be replaced by 'saledate_year', 'saledate_month', 'saledate_day'
FEATURES = ['year', 'make', 'model', 'trim', 'body', 'state', 'condition',
            'odometer', 'color', 'interior', 'seller', 'transmission',
            'saledate_year', 'saledate_month', 'saledate_day']

# The output/target of our model
LABEL = 'sellingprice'


# Read hive tables
car_prices = spark.read.format("avro").table(f'{DB_NAME}.{TABLE_NAME}')

split = F.split(F.to_date("saledate"), "-")
car_prices = car_prices.withColumn("saledate_year", split.getItem(0).cast(IntegerType()))\
    .withColumn("saledate_month", split.getItem(1).cast(IntegerType()))\
    .withColumn("saledate_day", split.getItem(2).cast(IntegerType()))


# Feature selection
car_prices = car_prices.select(FEATURES + [LABEL]).na.drop()
car_prices = car_prices.withColumnRenamed(LABEL, "label")

categoricalCols = ['make', 'body', 'state', 'color', 'interior', 'transmission']
textCols = ['model', 'trim', 'seller']
cyclicalCols = [('saledate_month', 12), ('saledate_day', 31)]
others = ['year', 'odometer', 'condition', 'saledate_year']


# Feature extraction
class CyclicalTransformer(
        Transformer,
        HasInputCol,
        HasOutputCol,
        DefaultParamsReadable,
        DefaultParamsWritable):
    """
    Transformer for encoding cyclical features
    """

    input_col = Param(
            Params._dummy(),
            "input_col",
            "input column name.",
            typeConverter=TypeConverters.toString
        )
    output_col = Param(
            Params._dummy(),
            "output_col",
            "output column name.",
            typeConverter=TypeConverters.toString
        )

    @keyword_only
    def __init__(self, period: float = 1, input_col: str = "input", output_col: str = "output"):
        super().__init__()
        self._setDefault(input_col=None, output_col=None)
        kwargs = self._input_kwargs
        del kwargs['period']
        self.set_params(**kwargs)
        self.period = period

    @keyword_only
    def set_params(self, input_col: str = "input", output_col: str = "output"):
        """
        Set parameters
        """

        kwargs = self._input_kwargs
        self._set(**kwargs)

    def get_input_col(self):
        """
        Get input column
        """
        
        return self.getOrDefault(self.input_col)

    def get_output_col(self):
        """
        Get output column
        """
        
        return self.getOrDefault(self.output_col)

    def _transform(self, dataset: DataFrame):
        input_col = self.get_input_col()
        output_col = self.get_output_col()

        sin_feature = F.sin(2 * math.pi / self.period * dataset[input_col])
        cos_feature = F.cos(2 * math.pi / self.period * dataset[input_col])
        return dataset.withColumn(output_col + "_sin", sin_feature)\
            .withColumn(output_col + "_cos", cos_feature)


stages = []
final_features = others.copy()

for textCol in textCols:
    output_col_name = f"{textCol}_encoded"

    tokenizer = Tokenizer(inputCol=textCol, outputCol=f"{textCol}_tokens")
    word2Vec = Word2Vec(
        vectorSize=5,
        seed=42,
        minCount=1,
        inputCol=tokenizer.getOutputCol(),
        outputCol=output_col_name
    )

    stages.append(tokenizer)
    stages.append(word2Vec)

    final_features.append(output_col_name)

for categoricalCol in categoricalCols:
    # Create String indexer to assign index for the string fields
    # String Indexer is required as an input for One-Hot Encoder
    # We set the case as `skip` for any string out of the input strings
    output_col_name = f"{categoricalCol}_encoded"

    indexer = StringIndexer(
        inputCol=categoricalCol,
        outputCol=f"{categoricalCol}_indexed"
    ).setHandleInvalid("skip")

    # Encode the strings using One Hot encoding
    encoder = OneHotEncoder(
        inputCol=indexer.getOutputCol(),
        outputCol=output_col_name
    )

    stages.append(indexer)
    stages.append(encoder)

    final_features.append(output_col_name)

for cyclicalCol, time_period in cyclicalCols:
    cyclical_transormer = CyclicalTransformer(
        period=time_period,
        input_col=cyclicalCol,
        output_col=cyclicalCol
    )

    stages.append(cyclical_transormer)

    final_features += [cyclicalCol + "_sin", cyclicalCol + "_cos"]

# This will concatenate the input cols into a single column.
assembler = VectorAssembler(inputCols=final_features, outputCol="features")
stages.append(assembler)

# You can create a pipeline to use only a single fit and transform on the data.
pipeline = Pipeline(stages=stages)


# Fit the pipeline ==> This will call the fit functions for all transformers if exist
model = pipeline.fit(car_prices)
# Fit the pipeline ==> This will call the transform functions for all transformers
data = model.transform(car_prices)

# We delete all features and keep only the features and label columns
data = data.select(["features", "label"])


# split the data into 60% training and 40% test (it is not stratified)
(train_data, test_data) = data.randomSplit([0.7, 0.3], seed=126)


def run(command):
    """
    Run the command in a shell
    """

    return os.popen(command).read()


train_data.select("features", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/train")
run("hdfs dfs -cat project/data/train/*.json > data/train.json")

test_data.select("features", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/test")
run("hdfs dfs -cat project/data/test/*.json > data/test.json")


# First model
# Create Linear Regression Model
lr = LinearRegression()

# Fit the data to the pipeline stages
model_lr = lr.fit(train_data)


# Predict for test data
predictions = model_lr.transform(test_data)


# Evaluate the performance of the model
evaluator1_rmse = RegressionEvaluator(
    labelCol="label", predictionCol="prediction", metricName="rmse")
evaluator1_r2 = RegressionEvaluator(
    labelCol="label", predictionCol="prediction", metricName="r2")

rmse = evaluator1_rmse.evaluate(predictions)
r2 = evaluator1_r2.evaluate(predictions)


# Hyperparameter optimization for model_lr
grid = ParamGridBuilder()
grid = grid.addGrid(model_lr.aggregationDepth, [2, 3, 4])\
    .addGrid(model_lr.regParam, np.logspace(1e-3, 1e-1))\
    .build()

cv = CrossValidator(estimator=lr,
                    estimatorParamMaps=grid,
                    evaluator=evaluator1_rmse,
                    parallelism=5,
                    numFolds=3)

cvModel = cv.fit(train_data)

# Best model 1
model1 = cvModel.bestModel


# Save the model to HDFS
model1.write().overwrite().save("project/models/model1")
run("hdfs dfs -get project/models/model1 models/model1")


# Predict for test data using best model1
predictions = model1.transform(test_data)

predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/model1_predictions.csv")
run("hdfs dfs -cat project/output/model1_predictions.csv/*.csv > output/model1_predictions.csv")


# Evaluate the best model1
evaluator1_rmse = RegressionEvaluator(
    labelCol="label", predictionCol="prediction", metricName="rmse")
evaluator1_r2 = RegressionEvaluator(
    labelCol="label", predictionCol="prediction", metricName="r2")

rmse1 = evaluator1_rmse.evaluate(predictions)
r21 = evaluator1_r2.evaluate(predictions)


# Second model
# Create GBTRegressor Model
gbt = GBTRegressor()

# Fit the data to the pipeline stages
model_gbt = gbt.fit(train_data)


# Predict for test data
predictions = model_gbt.transform(test_data)


# Evaluate the model_gbt
evaluator2_rmse = RegressionEvaluator(
    labelCol="label", predictionCol="prediction", metricName="rmse")
evaluator2_r2 = RegressionEvaluator(
    labelCol="label", predictionCol="prediction", metricName="r2")

rmse2 = evaluator2_rmse.evaluate(predictions)
r22 = evaluator2_r2.evaluate(predictions)


# Hyperparameter optimization for model_gbt
grid = ParamGridBuilder()
grid = grid.addGrid(model_gbt.maxDepth, [2, 5, 10])\
    .addGrid(model_gbt.lossType, ['squared', 'absolute'])\
    .build()

cv = CrossValidator(estimator=gbt,
                    estimatorParamMaps=grid,
                    evaluator=evaluator2_rmse,
                    parallelism=5,
                    numFolds=3)

cvModel = cv.fit(train_data)

# Best model 2
model2 = cvModel.bestModel


# Save the model2 to HDFS
model2.write().overwrite().save("project/models/model2")
run("hdfs dfs -get project/models/model2 models/model2")


# Predict for test data using best model2
predictions = model2.transform(test_data)

predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/model2_predictions.csv")
run("hdfs dfs -cat project/output/model2_predictions.csv/*.csv > output/model2_predictions.csv")


# Evaluate the best model2
evaluator2_rmse = RegressionEvaluator(
    labelCol="label", predictionCol="prediction", metricName="rmse")
evaluator2_r2 = RegressionEvaluator(
    labelCol="label", predictionCol="prediction", metricName="r2")

rmse2 = evaluator2_rmse.evaluate(predictions)
r22 = evaluator2_r2.evaluate(predictions)


# Compare best models
models = [[str(model1), rmse1, r21], [str(model2), rmse2, r22]]

results_df = spark.createDataFrame(models, ["model", "RMSE", "R2"])

results_df.coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/evaluation.csv")
run("hdfs dfs -cat project/output/evaluation.csv > output/evaluation.csv")
