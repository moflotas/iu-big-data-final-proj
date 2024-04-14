#!/bin/bash

set -xe

# Remove previously downloaded data
rm -f data/raw/*.csv

# Download dataset from kaggle (requires ~/.kaggle/kaggle.json file with token)
kaggle datasets download -d syedanwarafridi/vehicle-sales-data -p data/raw

# Unzip dataset
unzip data/raw/vehicle-sales-data.zip -d data/raw

# Remove archive
rm data/raw/vehicle-sales-data.zip

# Import data to postgres
python3 scripts/preprocess_data.py
