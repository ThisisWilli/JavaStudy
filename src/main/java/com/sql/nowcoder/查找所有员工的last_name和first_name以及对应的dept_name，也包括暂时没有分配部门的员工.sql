use MysqlExercise;
select *
from student
left join scores
on student.student_id = scores.student_id
inner join course c on scores.course_id = c.course_id;