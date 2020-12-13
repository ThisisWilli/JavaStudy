# 查询男生女生人数
use MysqlExercise;
select boy.num, girl.num
from
    (select count(student_sex) as num from student where student_sex = '男') as boy,
     (select count(student_sex) as num from student where student_sex = '女') as girl;

select student.student_sex, count(1) as num
from student
group by student.student_sex;

select count(if(student.student_sex='男', 1, null)) as '男生人数', count(if(student.student_sex = '女', 1, null)) as '女生人数'
from student;