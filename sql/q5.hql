USE team21_projectdb;

DROP TABLE IF EXISTS q5_results;
CREATE EXTERNAL TABLE q5_results
(
    condition    integer,
    avg_odometer float
)
    ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ','
    location 'project/hive/warehouse/q5';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q5_results
SELECT condition, AVG(odometer) AS avg_odometer
FROM car_prices_part_buck
WHERE condition IS NOT NULL
GROUP BY condition
ORDER BY condition;

SELECT *
FROM q5_results;