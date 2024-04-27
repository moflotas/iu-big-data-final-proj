USE team21_projectdb;

CREATE EXTERNAL TABLE car_prices_part_buck
(
    year         integer,
    make         string,
    model        string,
    trim         string,
    body         string,
    vin          string,
    state        string,
    condition    integer,
    odometer     integer,
    color        string,
    interior     string,
    seller       string,
    mmr          integer,
    sellingprice integer,
    saledate     date
)
    PARTITIONED BY (transmission string)
    CLUSTERED BY (vin) into 7 buckets
    STORED AS AVRO LOCATION 'project/hive/warehouse/car_prices_part_buck'
    TBLPROPERTIES ('AVRO.COMPRESS' = 'SNAPPY');

SET hive.exec.dynamic.partition.mode=nonstrict;
INSERT INTO car_prices_part_buck partition (transmission)
    (SELECT year,
            make,
            model,
            trim,
            body,
            vin,
            state,
            condition,
            odometer,
            color,
            interior,
            seller,
            mmr,
            sellingprice,
            from_unixtime(CAST(saledate / 1000 AS BIGINT),
                          'yyyy-MM-dd HH:mm:ss.SSS') AS saledate,
            transmission
     FROM car_prices);

DROP TABLE car_prices;
