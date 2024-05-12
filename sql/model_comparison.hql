USE team21_projectdb;

DROP TABLE IF EXISTS model_comparison;

CREATE EXTERNAL TABLE model_comparison
(
    model string,
    rmse  float,
    r2    float
)
    ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
    WITH SERDEPROPERTIES (
       "separatorChar" = ",",
       "quoteChar"     = "\""
    ) location 'project/hive/warehouse/model_comparison';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

LOAD DATA INPATH '/user/team21/project/output/evaluation.csv' OVERWRITE INTO TABLE model_comparison;

SELECT *
FROM model_comparison
LIMIT 10;