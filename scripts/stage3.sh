#!/bin/bash

# Reading secrets
PASSWORD=$(head -n 1 secrets/.hive.pass)

set -xe

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $password -f sql/q1.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q1.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $password -f sql/q2.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q2.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $password -f sql/q3.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q3.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $password -f sql/q4.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q4.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team21 -p $password -f sql/q5.hql --hiveconf hive.resultset.use.unique.column.names=false > output/q5.csv