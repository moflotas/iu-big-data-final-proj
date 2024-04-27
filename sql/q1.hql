USE team21_projectdb;

DROP TABLE IF EXISTS q1_results;
CREATE EXTERNAL TABLE q1_results
(
    color         string,
    average_price float
)
    ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ','
    location 'project/hive/warehouse/q1';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q1_results
SELECT color, AVG(sellingprice) AS average_price
FROM car_prices_part_buck
WHERE color IS NOT NULL
GROUP BY color
ORDER BY AVG(sellingprice) DESC;

SELECT *
FROM q1_results;