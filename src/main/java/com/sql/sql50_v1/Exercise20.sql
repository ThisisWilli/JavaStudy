# 查询出只选修两门课程的学生学号和姓名
use MysqlExercise;
select scores.student_id, count(scores.course_id) as '选课数量'
from scores
group by scores.student_id;
select student.student_id, student_name, scores2.选课数量
from student inner join
    (
        select scores.student_id, count(scores.course_id) as '选课数量'
        from scores
        group by scores.student_id
    ) as scores2
on student.student_id = scores2.student_id and scores2.选课数量 = 2

