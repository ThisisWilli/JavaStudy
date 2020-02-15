# 查询课程名称为「数学」，且分数低于 60 的学生姓名和分数 （三表联结）
use MysqlExercise;
select student.student_name, course.course_name, scores.score
from scores, course, student
where scores.course_id = course.course_id and course.course_name = '数学'
  and student.student_id = scores.student_id and scores.score <= 60;


delete from course where course_id = '03'

