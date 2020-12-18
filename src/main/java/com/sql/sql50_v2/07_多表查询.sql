use mysql_exercise;

# 查询所有学生的学号、姓名、选课数、总成绩
select score.student_id, s.student_name, count(score.course_id) as course_num, sum(score.score) as sum_score
from score
inner join student s on score.student_id = s.student_id
group by score.student_id;

# 查询平均成绩大于85的所有学生的学号、姓名、平均成绩
select score.student_id, s.student_name, avg(score.score) as avg_grade
from score
inner join student s on score.student_id = s.student_id
group by score.student_id
having avg_grade > 85;

# 查询每门课程的及格人数和不及格人数 2 1  2
# solution 1
select p.course_id, p.pass, not_p.not_pass
from
(
    select score.course_id, count(score.score) as pass
    from score
    where score.score > 60
    group by score.course_id
) as p
inner join
(
    select score.course_id, count(score.score) as not_pass
    from score
    where score.score < 60
    group by score.course_id
) as not_p
on p.course_id = not_p.course_id;

# solution 2
select
       score.course_id,
       sum(if(score.score > 60, 1, 0)) as pass,
       sum(if(score.score < 60, 1, 0)) as not_pass
from score
group by score.course_id;

# solution 3
select
    score.course_id,
    sum(case when score.score > 60 then 1 else 0 end) as pass,
    sum(case when score.score < 60 then 1 else 0 end) as not_pass
from score
group by score.course_id;



# 使用分段[100-85], [85-70], [70, 60], [<60]来统计各科成绩，分别统计：各分段人数，课程号和课程名称
select
       score.course_id,
       sum(if(score.score > 85 and score.score < 100, 1, 0)) as score_85_100,
       sum(if(score.score > 70 and score.score < 85, 1, 0)) as score_70_85,
       sum(if(score.score > 60 and score.score < 70, 1, 0)) as score_60_70,
       sum(if(score.score < 100, 1, 0)) as score_60
from score
group by score.course_id;

# 查询课程编号为0003且课程成绩在80分以上的学生的学号和姓名
select score.student_id, s.student_name
from score
inner join student s
on score.student_id = s.student_id
where score.course_id = '03' and score.score > 80;

# 用sql实现行专列 将学号 课程号 成绩 转化为 学号，课程1，课程2，课程3
select
    score.student_id,
    max(if(score.course_id = '01', score.score, 0)) as 'course01',
    max(if(score.course_id = '02', score.score, 0)) as 'course02',
    max(if(score.course_id = '03', score.score, 0)) as 'course03'
from score
group by score.student_id;