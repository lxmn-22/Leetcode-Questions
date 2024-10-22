"""
DataFrame: employees
+-------------+--------+
| Column Name | Type   |
+-------------+--------+
| employee_id | int    |
| name        | object |
| department  | object |
| salary      | int    |
+-------------+--------+
Write a solution to display the first 3 rows of this DataFrame.
"""
import pandas as pd

def selectFirstRows(employees: pd.DataFrame) -> pd.DataFrame:
    # return employees.head(3)
    return employees.iloc[0:3]
    