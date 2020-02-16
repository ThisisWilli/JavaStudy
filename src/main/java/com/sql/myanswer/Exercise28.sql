# 查询所有学生的课程及分数情况（存在学生没成绩，没选课的情况）
use MysqlExercise;
select student.student_id, scores.course_id, student.student_name, scores.score
from scores, student where student.student_id = scores.student_id;