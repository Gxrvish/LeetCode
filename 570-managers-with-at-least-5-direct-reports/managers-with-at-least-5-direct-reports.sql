# Write your MySQL query statement below
select e.name
from Employee as e
inner join (select managerId, count(managerId) as counti
        from Employee 
        where managerId > 4
        group by managerId) as n
on n.managerId = e.id
where n.counti > 4