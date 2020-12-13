# 查询任何一门成绩在70分以上的姓名以及课程分数
use MysqlExercise;

select *
from scores, student
where scores.score > 70 and scores.student_id = student.student_id;