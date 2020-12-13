use MysqlExercise;
# 查询和" 01 "号的同学学习的课程完全相同的其他同学的信息, count后面跟groupby，说明按照指定列中的中类个数统计对应count列中的种类个数
select others.student_id, stu.student_name
from
    (select student_id, count(course_id) as stu1_num from scores where student_id = '01' group by student_id)  as stu01
join
    (select student_id, count(course_id) as other_num from scores where student_id != '01'group by student_id) as others
join
    (select * from student) as stu
on stu1_num = other_num and stu.student_id = others.student_id;