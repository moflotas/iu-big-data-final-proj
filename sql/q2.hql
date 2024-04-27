USE team21_projectdb;

DROP TABLE IF EXISTS q2_results;
CREATE EXTERNAL TABLE q2_results
(
    state           string,
    automatic_count integer,
    manual_count    integer
)
    ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ','
    location 'project/hive/warehouse/q2';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q2_results
SELECT state,
       SUM(CASE WHEN transmission = 'automatic' THEN 1 ELSE 0 END) AS automatic_count,
       SUM(CASE WHEN transmission = 'manual' THEN 1 ELSE 0 END)    AS manual_count
FROM car_prices_part_buck
WHERE transmission IS NOT NULL
GROUP BY state;

SELECT *
FROM q2_results;