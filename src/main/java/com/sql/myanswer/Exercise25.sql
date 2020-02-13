# 查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列

use MysqlExercise;
select avg(scores.score) as 平均成绩
from scores
group by scores.course_id
order by 平均成绩, scores.course_id;

select sc1.sc from
       (
         select scores.score as sc
         from scores
         order by scores.score desc
         limit 0, 2
     ) as sc1;

select scores.score as sc
from scores
order by scores.score desc
limit 0 offset 2