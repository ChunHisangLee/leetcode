# There is no code of Python3 type for this problem
import pandas as pd


def dropDuplicateEmails(customers: pd.DataFrame) -> pd.DataFrame:
    customers = customers.drop_duplicates(keep='first', subset='email')
    return customers
