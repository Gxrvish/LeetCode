# Write your MySQL query statement below
SELECT stock_name, SUM(IF(operation = 'Sell', price, 0)) - SUM(IF(operation = 'Buy', price, 0)) as capital_gain_loss
from stocks
group by stock_name