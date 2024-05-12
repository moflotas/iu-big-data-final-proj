USE team21_projectdb;

DROP TABLE IF EXISTS model1_predictions;

CREATE EXTERNAL TABLE model1_predictions
(
    label float,
    prediction  float
)
    ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ','
    location 'project/hive/warehouse/model1_predictions';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

LOAD DATA INPATH '/user/team21/project/output/model1_predictions.csv' OVERWRITE INTO TABLE model1_predictions;

SELECT *
FROM model1_predictions
LIMIT 10;
