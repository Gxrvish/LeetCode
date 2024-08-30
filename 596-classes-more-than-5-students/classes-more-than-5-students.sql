SELECT class 
FROM (
    SELECT class, count(class) as no_of_class
    FROM courses
    GROUP BY class
) as no WHERE no_of_class >= 5