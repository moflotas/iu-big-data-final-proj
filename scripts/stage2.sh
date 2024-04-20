#!/bin/bash

# Reading secrets
PASSWORD=$(head -n 1 secrets/.hive.pass)

set -xe

hdfs dfs -test -d project/warehouse/avsc && hdfs dfs -rm -r -skipTrash project/warehouse/avsc

hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put output/*.avsc project/warehouse/avsc

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $PASSWORD -f sql/db.hql > output/hive_results.txt 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $PASSWORD -f sql/optimizations.hql > /dev/null 2> /dev/null

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $password -f sql/q1.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q1.csv 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $password -f sql/q2.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q2.csv 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $password -f sql/q3.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q3.csv 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $password -f sql/q4.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q4.csv 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $password -f sql/q5.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q5.csv 2> /dev/null
