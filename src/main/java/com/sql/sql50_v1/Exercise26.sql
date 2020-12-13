# 查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩
use MysqlExercise;
select student.student_id, student.student_name,avg(scores.score) as 平均成绩
from scores, student
where scores.student_id = student.student_id
group by scores.student_id, student_name
having 平均成绩 > 85;

