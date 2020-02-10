# 查询每门课程被选修的学生数
use MysqlExercise;
select course.course_id, count(scores.score) as '选课人数'
from scores, course
where scores.course_id = course.course_id
group by scores.course_id;