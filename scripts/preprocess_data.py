"""
Preprocess the car prices dataset.
"""

import numpy as np
import pandas as pd
from tqdm import tqdm
from dateutil.parser import parse

tqdm.pandas()

df = pd.read_csv(
    "data/raw/car_prices.csv",
    dtype={
        "year": pd.Int64Dtype(),
        "condition": pd.Int64Dtype(),
        "odometer": pd.Int64Dtype(),
        "mmr": pd.Int64Dtype(),
        "sellingprice": pd.Int64Dtype(),
    },
)

bad_rows = df[
    (df["transmission"] != "automatic")
    & (df["transmission"] != "manual")
    & (~df["transmission"].isna())
]

df_dropped_shifted_rows = df.drop(bad_rows.index)


def parse_saledate(s: str) -> str:
    """
    Parse a string to a datetime object using dateutil.parser.parse.
    """
    if pd.isna(s):
        return np.nan
    return parse(s)

df_parsed_saledate = df_dropped_shifted_rows.copy()
df_parsed_saledate["saledate"] = df_dropped_shifted_rows["saledate"].progress_apply(
    parse_saledate
)

df_parsed_saledate.to_csv("data/preprocessed/car_prices.csv", index=False)
