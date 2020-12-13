# 求每门课程的学生人数
use MysqlExercise;
select student_id, count(course_id) as 选课数量
from scores
group by student_id;