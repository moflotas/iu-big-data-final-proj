"""
Script for filling postgres database with raw data
"""

import os
from pprint import pprint
import sys
import psycopg2 as psql


def read_file(path: str) -> str:
    """
    Read whole file as string
    """
    if not os.path.exists(path):
        print(f"File {path} does not exist")
        sys.exit(1)

    with open(path, encoding="utf-8") as file:
        return file.read().strip()


# Path to password
PASSWORD_PATH = os.path.join("secrets", ".psql.pass")

# Connection credentials
TEAM_NUMBER = 21
HOST = "hadoop-04.uni.innopolis.ru"
PORT = 5432
USER = f"team{TEAM_NUMBER}"
DBNAME = f"team{TEAM_NUMBER}_projectdb"
PASSWORD = read_file(PASSWORD_PATH)

# build connection string
CONNECTION_STRING = (
    f"host={HOST} port={PORT} user={USER} dbname={DBNAME} password={PASSWORD}"
)

# Sql scripts
CREATE_TABLES = "sql/create_tables.sql"
IMPORT_DATA = "sql/import_data.sql"
TEST_DATABASE = "sql/test_database.sql"

# Dataset path
DATASET = "data/car_prices.csv"


def main():
    """
    Program entrypoint
    """
    # Connect to the remote dbms
    with psql.connect(CONNECTION_STRING) as conn:

        # Create a cursor for executing psql commands
        cur = conn.cursor()

        # Read the commands from the file and execute them.
        cur.execute(read_file(CREATE_TABLES))
        conn.commit()

        # Read the commands from the file and execute them.
        with open(DATASET, encoding="utf-8") as file:
            cur.copy_expert(read_file(IMPORT_DATA), file)
        conn.commit()

        for command in read_file(TEST_DATABASE).split("\n"):
            cur.execute(command)
            # Read all records and print them
            pprint(cur.fetchall())


if __name__ == "__main__":
    main()
