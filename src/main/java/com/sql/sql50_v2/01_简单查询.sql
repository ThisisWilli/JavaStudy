show databases;

use mysql_exercise;
select * from student;
select * from course;
select * from teacher;
select * from score;


# 查询姓XX的学生名单
select *
from student stu
where stu.student_name like "李%";

# 查询孟姓老师的个数
select count(teacher.teacher_id)
from teacher
where teacher.teacher_name like "孟%";