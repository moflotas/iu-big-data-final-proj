START TRANSACTION;

DROP TABLE IF EXISTS car_prices;

CREATE TABLE car_prices (
    year INT,
    make VARCHAR(255),
    model VARCHAR(255),
    trim VARCHAR(255),
    body VARCHAR(255),
    transmission VARCHAR(255),
    vin VARCHAR(255),
    state VARCHAR(255),
    condition INT,
    odometer INT,
    color VARCHAR(255),
    interior VARCHAR(255),
    seller VARCHAR(255),
    mmr INT,
    sellingprice INT,
    saledate TIMESTAMP
);

COMMIT;

