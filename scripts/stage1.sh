#!/bin/bash

# Remove all files from data folder except *.MD
find data -type f ! -name "*.MD" -delete

# Download dataset from kaggle (requires ~/.kaggle/kaggle.json file with token)
kaggle datasets download -d syedanwarafridi/vehicle-sales-data -p data

# Unzip dataset
unzip data/vehicle-sales-data.zip -d data/

# Remove archive
rm data/vehicle-sales-data.zip
