use MysqlExercise;
# 按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
select scores.student_id, scores.course_id, scores.score, 平均成绩
from scores
left join
    (select scores.student_id,avg(scores.score) as '平均成绩' from scores group by scores.student_id) as avg_scores
on scores.student_id = avg_scores.student_id
order by avg_scores.平均成绩 desc ;