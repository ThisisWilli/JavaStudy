use MysqlExercise;
# 查询没学过"张三"老师讲授的任一门课程的学生姓名, 注意没有成绩的学生
select *
from student where student_id
not in(select student.student_id
from student
left join scores on scores.student_id = student.student_id
left join course on course.course_id = scores.course_id
left join teacher on teacher.teacher_id = course.teacher_id
where teacher_name='张三');
