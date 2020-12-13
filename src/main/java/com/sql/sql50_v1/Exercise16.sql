use MysqlExercise;
# 查询学生的总成绩，并进行排名，总分重复时保留名次空缺
select scores.student_id, count(scores.course_id) as '选课总数',sum(scores.score) as '总分', avg(scores.score) as '平均分'
from scores
group by scores.student_id order by 总分;