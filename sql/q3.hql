USE team21_projectdb;

DROP TABLE IF EXISTS q3_results;
CREATE EXTERNAL TABLE q3_results
(
    body       string,
    body_count integer
)
    ROW FORMAT DELIMITED
        FIELDS TERMINATED BY ','
    location 'project/hive/warehouse/q3';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

WITH body_counts AS (SELECT LOWER(body)                          AS body,
                            COUNT(*)                             AS body_count,
                            RANK() OVER (ORDER BY COUNT(*) DESC) AS body_rank
                     FROM car_prices_part_buck
                     GROUP BY body)
INSERT INTO q3_results
SELECT CASE
           WHEN body_rank <= 10 THEN body
           ELSE 'other'
           END         AS body,
       SUM(body_count) AS body_count
FROM body_counts
WHERE body IS NOT NULL
GROUP BY CASE
             WHEN body_rank <= 10 THEN body
             ELSE 'other'
             END
ORDER BY body_count DESC;

SELECT *
FROM q3_results;