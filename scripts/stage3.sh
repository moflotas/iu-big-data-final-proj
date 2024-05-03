#!/bin/bash

set -xe

spark-submit --master yarn scripts/model.py

# Split large train.json file into 2 parts
awk '{ print > ( "data/train" (NR>(n/2) ? 2 : 1) ".json" ) }' n="$(wc -l <data/train.json)" data/train.json
rm data/train.json
