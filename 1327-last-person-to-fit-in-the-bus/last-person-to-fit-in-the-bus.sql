WITH queue_cumulative AS (
  SELECT turn, person_name, weight,
         SUM(weight) OVER (ORDER BY turn ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS total_weight
  FROM queue
)
SELECT person_name
FROM queue_cumulative
WHERE total_weight <= 1000
ORDER BY turn DESC
LIMIT 1;
