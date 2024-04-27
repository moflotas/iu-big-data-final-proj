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


# change '—' to NaN
def change_dash_to_nan(value: str) -> str:
    """
    Change a dash to NaN.
    """
    if value == "—":
        return np.nan
    return value

df_fixed_dash = df_dropped_shifted_rows.copy()
df_fixed_dash["color"] = df_fixed_dash["color"].progress_apply(
    change_dash_to_nan
)


def parse_saledate(date: str) -> str:
    """
    Parse a string to a datetime object using dateutil.parser.parse.
    """
    if pd.isna(date):
        return np.nan
    return parse(date)

df_parsed_saledate = df_fixed_dash.copy()
df_parsed_saledate["saledate"] = df_parsed_saledate["saledate"].progress_apply(
    parse_saledate
)

df_parsed_saledate.to_csv("data/preprocessed/car_prices.csv", index=False)
