-- Drop database if exists and create a new database
DROP DATABASE IF EXISTS team21_projectdb CASCADE;
CREATE DATABASE team21_projectdb LOCATION "project/hive/warehouse";
USE team21_projectdb;

-- Create table for car prices
CREATE EXTERNAL TABLE car_prices STORED AS AVRO LOCATION 'project/warehouse/car_prices' TBLPROPERTIES ('avro.schema.url' = 'project/warehouse/avsc/car_prices.avsc');

-- For checking the content of tables
SELECT * FROM car_prices LIMIT 10;
