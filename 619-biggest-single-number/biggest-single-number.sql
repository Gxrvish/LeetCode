# Write your MySQL query statement below

SELECT max(num) AS num FROM (
    SELECT num, count(num) AS no
    FROM mynumbers
    GROUP BY num
) AS temp
WHERE no=1