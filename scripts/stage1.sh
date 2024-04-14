#!/bin/bash

# Reading secrets
PASSWORD=$(head -n 1 secrets/.psql.pass)

set -xe

# Import data to postgres
python3 scripts/build_projectdb.py

# Remove previously created data in HDFS
hdfs dfs -test -d project && hdfs dfs -rm -r -skipTrash project

# Remove previously autog-generated .avsc and .java files
rm -f output/*.java output/*.avsc

# Import the database into HDFS via Sqoop
sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru:5432/team21_projectdb --username team21 --password $PASSWORD --compression-codec=snappy --compress --as-avrodatafile --warehouse-dir=project/warehouse --m 1 --outdir output
