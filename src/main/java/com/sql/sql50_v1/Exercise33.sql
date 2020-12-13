#  成绩不重复，查询选修「张三」老师所授课程的学生中，成绩最高的学生信息及其成绩
use MysqlExercise;
select student.student_id, student_name, course.course_id, course.course_name, scores.score, teacher.teacher_name
from scores, course, teacher, student
where course.course_id = scores.course_id and course.teacher_id = teacher.teacher_id
    and teacher.teacher_name = '张三' and student.student_id = scores.student_id
order by scores.score desc
limit 1;