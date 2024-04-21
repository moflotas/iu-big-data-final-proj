#!/bin/bash

# Reading secrets
PASSWORD=$(head -n 1 secrets/.hive.pass)

set -xe

hdfs dfs -test -d project/warehouse/avsc && hdfs dfs -rm -r -skipTrash project/warehouse/avsc

hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put output/*.avsc project/warehouse/avsc

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $PASSWORD -f sql/db.hql > output/hive_results.txt 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $PASSWORD -f sql/optimizations.hql > /dev/null 2> /dev/null

for ((i = 1; i <= 5; i++))
do
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $PASSWORD -f sql/q$i.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q$i.csv 2> /dev/null
done
