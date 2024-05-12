USE team21_projectdb;

DROP TABLE IF EXISTS model2_predictions;

CREATE EXTERNAL TABLE model2_predictions
(
    label float,
    prediction  float
)
    ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ','
    location 'project/hive/warehouse/model2_predictions';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

LOAD DATA INPATH '/user/team21/project/output/model2_predictions.csv' OVERWRITE INTO TABLE model2_predictions;

SELECT *
FROM model2_predictions
LIMIT 10;
