# Write your MySQL query statemen
SELECT IF(id < (SELECT  MAX(id) FROM seat), IF(id%2 = 0, id-1, id+1), IF(id%2 = 0, id-1, id)) 
AS id, student 
FROM seat 
ORDER BY id