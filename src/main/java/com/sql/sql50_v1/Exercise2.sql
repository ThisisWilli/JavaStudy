use  MysqlExercise;

# 查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
# 先查询每个学生的平均成绩
select stu.student_id, stu.student_name, avgScore
from
    (select scores.student_id, avg(scores.score) as avgScore from scores group by scores.student_id) avg
join
    (select student.student_id, student.student_name from student) as stu
on stu.student_id = avg.student_id
where avgScore > 60;




