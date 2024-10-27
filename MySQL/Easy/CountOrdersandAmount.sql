/*
Table: Users.
+----------------+----------+
| Column Name    | Type     |
+----------------+----------+
| user_id        | int      |
| user_name      | varchar  |
+----------------+----------+
user_id is the column of unique values for this table.
Each row contains information about a user.

Script: Users.
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    user_name VARCHAR(255)
);

Table: Orders.
+----------------+----------+
| Column Name    | Type     |
+----------------+----------+
| order_id       | int      |
| user_id        | int      |
| amount         | decimal  |
| order_date     | datetime |
+----------------+----------+
order_id is the primary key for this table.
user_id is a foreign key (reference column) to the Users table.
Each row contains information about an order made by a user, including the amount of the order.

Script: Orders.
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    user_id INT,
    amount DECIMAL(10, 2),
    order_date DATETIME,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);


TThe query retrieves each user's ID, name, the total number of orders 
they have placed, and the total amount they have spent on those orders. 
If a user has not placed any orders, they will still be included in the
results with a count of zero and a total amount of zero.

Example 1:
Input: 
Users table:
+---------+-----------+
| user_id | user_name |
+---------+-----------+
|       1 | Jagadeesh |
|       2 | John      |
|       3 | Abhraham  |
|       4 | Paul      |
|       5 | Lincoln   |
+---------+-----------+
Confirmations table:
+----------+---------+--------+---------------------+
| order_id | user_id | amount | order_date          |
+----------+---------+--------+---------------------+
|        1 |       1 | 150.00 | 2024-01-15 10:30:00 |
|        2 |       1 | 200.00 | 2024-01-20 12:45:00 |
|        3 |       2 | 100.00 | 2024-01-22 09:00:00 |
|        4 |       2 |  50.00 | 2024-01-25 14:30:00 |
|        5 |       3 | 300.00 | 2024-01-26 11:15:00 |
|        6 |       3 | 150.00 | 2024-01-27 15:00:00 |
|        7 |       4 | 400.00 | 2024-01-28 16:00:00 |
|        8 |       5 |   0.00 | 2024-01-29 09:45:00 |
+----------+---------+--------+---------------------+
Output: 
+---------+-----------+--------------+-------------+
| user_id | user_name | total_orders | total_spent |
+---------+-----------+--------------+-------------+
|       1 | Jagadeesh |            2 |      350.00 |
|       2 | John      |            2 |      150.00 |
|       3 | Abhraham  |            2 |      450.00 |
|       4 | Paul      |            1 |      400.00 |
|       5 | Lincoln   |            1 |        0.00 |
+---------+-----------+--------------+-------------+
Explanation: 
Jagadeesh, with user ID 1, has placed a total of 2 orders and spent a total of $350.00. 
John, who has user ID 2, also made 2 orders but spent only $150.00. 
Abhraham, with user ID 3, matched the order count of Jagadeesh, having placed 2 orders as well, 
but he spent a higher total of $450.00. 
Paul, identified by user ID 4, has placed 1 order, for which he spent $400.00. 
Lastly, Lincoln, who has user ID 5, placed 1 order, but it resulted in a total expenditure of $0.00, 
indicating that the order did not require any payment.
*/

SELECT 
    u.user_id,
    u.user_name,
    COUNT(o.order_id) AS total_orders,
    COALESCE(SUM(o.amount), 0) AS total_spent
FROM Users AS u
LEFT JOIN Orders AS o 
ON u.user_id = o.user_id
GROUP BY u.user_id, u.user_name
ORDER BY u.user_id;