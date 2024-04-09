START TRANSACTION;

COPY car_prices FROM 'data/car_prices.csv' WITH CSV HEADER DELIMITER ',' NULL AS 'null';

COMMIT;
