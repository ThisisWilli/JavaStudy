use mysql_exercise;

# 查询学生平均成绩及其名次
# solution 采用自联结的方式
select s1.student_id, s1.avg, count(s2.avg) as rank_num
from
(
    select score.student_id, avg(score.score) as avg
    from score
    group by score.student_id
) as s1
inner join
(
    select score.student_id, avg(score.score) as avg
    from score
    group by score.student_id
) as s2
on s1.avg <= s2.avg
group by s1.student_id
order by rank_num;

# 按各科成绩进行排序，并显示排名
select score.course_id, score.student_id, score.score
from score
order by score.course_id, score.score desc;

# 查询每门课程成绩最好的前两名学生的姓名(分组排名)
# solution 1 mysql8.0以下采用自变量解题
select ss.course_id, ss.score, ss.rank_num
from
(
    select
        s.course_id,
        s.score,
        case
            when @pre = s.course_id then @`rank` := @`rank` + 1
            when @pre := s.course_id then @`rank` := 1
            end as rank_num
    from
        (
            select score.course_id, score.student_id, score.score
            from score
            order by score.course_id, score.score desc
        ) as s,(select @pre := null, @rank := 0) as tt
) as ss
where rank_num < 3;

# solution 2
select *
from
(
    select score.course_id, score.student_id, score.score
    from score
    order by score.course_id, score.score desc
) as s1;


# 查询所有课程的成绩第2名到第3名的学生信息及该课程成绩
select s2.student_id, s2.score, s2.rank_num
from
(
    select
    s.student_id,
    s.score,
    case
        when @pre = s.course_id then @rank := @rank + 1
        when @pre := s.course_id then @rank := 1
    end as rank_num
    from
    (
        select *
        from score
        order by score.course_id, score.score desc
    ) as s , (select @pre := null, @rank := 0) as tt
) as s2
where s2.rank_num = 2 or s2.rank_num = 3;

# 查询各科成绩前3名的记录，不考虑成绩并列的情况
select ss.course_id, ss.score, ss.rank_num
from
    (
        select
            s.course_id,
            s.score,
            case
                when @pre = s.course_id then @`rank` := @`rank` + 1
                when @pre := s.course_id then @`rank` := 1
                end as rank_num
        from
            (
                select score.course_id, score.student_id, score.score
                from score
                order by score.course_id, score.score desc
            ) as s,(select @pre := null, @rank := 0) as tt
    ) as ss
where rank_num <= 3;
