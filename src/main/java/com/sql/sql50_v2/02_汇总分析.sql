use mysql_exercise;

# 查询课程编号为02的总成绩
select sum(score.score)
from score
where score.score_id = 02;


# 查询选了课程的学生人数
## solution_1：通过group by去重之后，再统计人数
select count(sc.student_id)
from
(
    select score.student_id
    from score
    group by score.student_id
) as sc;

## solution_2：利用distinct
select count(distinct score.student_id)
from score
