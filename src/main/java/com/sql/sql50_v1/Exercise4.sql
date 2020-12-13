# 查询所有同学的学生编号，学生姓名，选课总数，所有课程的总成绩（没成绩的显示为null）
use MysqlExercise;
select student.student_id, student.student_name, scores.sumScore as '总成绩', scores.选课数量
from student
left join
    (select scores.student_id,sum(scores.score) as sumScore, count(scores.course_id) as '选课数量'
        from scores group by scores.student_id) as scores
on student.student_id = scores.student_id
