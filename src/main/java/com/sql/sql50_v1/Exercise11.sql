use MysqlExercise;
# 查询两门课及其以上不及格同学的学号，姓名，及平均成绩
# having可以对聚合后的数据进行筛选
select student.student_id, student.student_name, avg(scores.score)
from student, scores
where student.student_id = scores.student_id and scores.score < 60
group by student.student_name, scores.student_id
having count(course_id) >= 2;


