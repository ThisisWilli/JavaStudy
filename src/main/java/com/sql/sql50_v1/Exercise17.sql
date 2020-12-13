# 统计各科成绩各分数段人数，课程编号，课程名称 [100-85]，[85-70]，[70-60]，[60-0] 及所占百分比
use MysqlExercise;
select *
from scores;

select
       scores.course_id,
       course.course_name,
       sum(IF(scores.score between 85 and 100, 1, 0)) / count(*) * 100 as '85-100',
       sum(if(scores.score between 70 and 85, 1, 0)) /count(*) * 100 as '70-85',
       sum(if(scores.score between 60 and 70, 1, 0)) / count(*) * 100 as '60-70',
       sum(if(scores.score < 60, 1, 0)) / count(*) * 100 as '0-60'
#     round(sum(if(scores.score >= 85, 1, 0) / count(*) * 100, 0)
#     round (sum(case when score >=85 then 1 else 0 end)/count(*)*100,0),'%')
from scores, course
where scores.course_id = course.course_id
group by scores.course_id, course_name