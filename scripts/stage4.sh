#!/bin/bash

# Reading secrets
PASSWORD=$(head -n 1 secrets/.hive.pass)

set -xe

hdfs dfs -put -f output/model1_predictions.csv project/output/
hdfs dfs -put -f output/model2_predictions.csv project/output/
hdfs dfs -put -f output/evaluation.csv project/output/

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $PASSWORD -f sql/model1_predictions.hql > /dev/null 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $PASSWORD -f sql/model2_predictions.hql > /dev/null 2> /dev/null
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $PASSWORD -f sql/model_comparison.hql > /dev/null 2> /dev/null
