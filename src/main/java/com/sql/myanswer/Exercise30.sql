# 查询不及格的课程
use MysqlExercise;
select scores.student_id, course.course_name, scores.score
from scores
inner join
course
where scores.course_id = course.course_id and scores.score < 60;