# 查询scores表中存在成绩的学生
use MysqlExercise;
select scores.student_id, student.student_name, scores.score
from student
join
(select * from scores) as scores
on student.student_id = scores.student_id;