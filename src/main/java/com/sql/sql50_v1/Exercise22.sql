# 查询名字中带有风字的学生
use MysqlExercise;
select *
from student
where student.student_name like '%风%';
