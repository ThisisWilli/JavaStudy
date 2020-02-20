# 查询课程编号为 01 且课程成绩在 80 分以上的学生的学号和姓名
use MysqlExercise;
select student.student_id, student.student_name, scores.course_id, scores.score
from scores
inner join student
on scores.score >= 80 and scores.course_id = 01 and scores.student_id = student.student_id;