# There is no code of Python3 type for this problem
import pandas as pd


def dropMissingData(students: pd.DataFrame) -> pd.DataFrame:
    students = students[students['name'].notna()]
    return students
