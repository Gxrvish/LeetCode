# Write your MySQL query statement below
select p.project_id, IFNULL(ROUND(AVG(e.experience_years), 2), 0) as average_years 
from project p
join employee e
on p.employee_id = e.employee_id
group by project_id