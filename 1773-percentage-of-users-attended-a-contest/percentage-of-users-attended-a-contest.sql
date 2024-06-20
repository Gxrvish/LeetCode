select contest_id, ROUND(COUNT(user_id)*100/(SELECT COUNT(user_id) FROM users), 2) as percentage
from Register
group by contest_id
order by percentage desc, contest_id asc