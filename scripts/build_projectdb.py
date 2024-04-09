import psycopg2 as psql
from pprint import pprint
import os


def read_file(path: str) -> str:
    if not os.path.exists(PASSWORD_PATH):
        print("File {} does not exist".format(path))
        exit(1)

    with open(path) as f:
        return f.read().strip()


# Path to password
PASSWORD_PATH = os.path.join("secrets", ".psql.pass")

# Connection credentials
TEAM_NUMBER = 21
HOST = "hadoop-04.uni.innopolis.ru"
PORT = 5432
USER = "team{}".format(TEAM_NUMBER)
DBNAME = "team{}_projectdb".format(TEAM_NUMBER)
PASSWORD = read_file(PASSWORD_PATH)

# build connection string
CONNECTION_STRING = "host={} port={} user={} dbname={} password={}".format(
    HOST, PORT, USER, DBNAME, PASSWORD
)

# Sql scripts
CREATE_TABLES = "sql/create_tables.sql"
IMPORT_DATA = "sql/import_data.sql"
TEST_DATABASE = "sql/test_database.sql"

# Dataset path
DATASET = "data/car_prices.csv"


def main():
    # Connect to the remote dbms
    with psql.connect(CONNECTION_STRING) as conn:

        # Create a cursor for executing psql commands
        cur = conn.cursor()

        # Read the commands from the file and execute them.
        cur.execute(read_file(CREATE_TABLES))
        conn.commit()

        # Read the commands from the file and execute them.
        with open(DATASET) as f:
            cur.copy_expert(read_file(IMPORT_DATA), f)
        conn.commit()

        for command in read_file(TEST_DATABASE).split():
            cur.execute(command)
            # Read all records and print them
            pprint(cur.fetchall())


if __name__ == "__main__":
    main()
