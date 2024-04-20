USE team21_projectdb;

DROP TABLE IF EXISTS q4_results;
CREATE EXTERNAL TABLE q4_results
(
    sale_date   string,
    sales_count integer
)
    ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ','
    location 'project/hive/warehouse/q4';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q4_results
SELECT DATE_FORMAT(saledate, 'yyyy.MM') AS sale_date, COUNT(*) AS sales_count
FROM car_prices_part_buck
WHERE saledate IS NOT NULL
GROUP BY DATE_FORMAT(saledate, 'yyyy.MM')
ORDER BY sale_date;

SELECT *
FROM q4_results;