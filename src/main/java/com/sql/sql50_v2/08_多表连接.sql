use mysql_exercise;

# 查询01课程分数小于60，按分数降序排列的学生信息
select score.student_id, s.student_name, score.score
from score
inner join student s on score.student_id = s.student_id
where score.course_id = '01' and score.score < 60
order by score.score;

# 查询不同老师所教不同课程平均分从高到低显示
select t.teacher_name, c.course_id, avg(s.score)
from score s
inner join course c on s.course_id = c.course_id
inner join teacher t on c.teacher_id = t.teacher_id
group by c.teacher_id;

# 查询课程名为数学，且分数低于60的学生姓名和分数
select s.student_id, s2.student_name, s.score
from score s
inner join course c on s.course_id = c.course_id
inner join student s2 on s.student_id = s2.student_id
where c.course_name = '数学' and s.score < 60;

# 查询任何一门课程成绩在70分以上的学生姓名、课程名称和分数
select s2.student_name, c.course_name, s.score
from score s
inner join course c on s.course_id = c.course_id
inner join student s2 on s.student_id = s2.student_id
where s.score > 70;


# 查询任何两门及其以上不及格课程的同学的学号，姓名及其平均成绩
select s.student_id, s2.student_name, avg(score)
from score as s
inner join student s2 on s.student_id = s2.student_id
where s.score < 60
group by s.student_id
having count(s.student_id) >= 2;

# 查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩
select s1.student_id, s1.score, s2.student_id, s2.score
from score s1, score s2
where s1.score = s2.score and s1.student_id != s2.student_id
group by s1.student_id, s2.student_id;

# 查询课程编号为01的课程比02的课程成绩高的所有学生的学号
# solution 1
select s.student_id, s1.course_id, s1.score, s2.course_id, s2.score
from score s1, score s2
inner join student s on s2.student_id = s.student_id
where s1.course_id = '01' and s2.course_id = '02' and s1.score > s2.score
group by s.student_id;

# solution 2
select a.student_id
from
(select s1.student_id, s1.score from score s1 where s1.course_id = '01') as a
inner join
(select s1.student_id, s1.score from score s1 where s1.course_id = '02') as b
on a.student_id = b.student_id
inner join student c on c.student_id = a.student_id
where a.score > b.score;

# 查询学过编号为01的课程并且也学过编号为02的课程的学生的学号、姓名
select s1.student_id
from score s1
where s1.course_id = '01' and s1.student_id in
(
    select s2.student_id
    from score s2
    where s2.course_id = '02'
);

# 查询学过李四老师所教的所有课的同学的学号，姓名
# solution 1
select student.student_id, student.student_name
from student
inner join
(
    select score.student_id
    from score
    where score.course_id in
    (
        select c.course_id
        from course c
        inner join teacher t on c.teacher_id = t.teacher_id
        where t.teacher_name = '李四'
    )
) as sc
on sc.student_id = student.student_id
group by student.student_id;

# solution 2 避免使用in
select s.student_id, s2.student_name
from score s
inner join
(
    select c.course_id
    from course c
    inner join teacher t on c.teacher_id = t.teacher_id
    where t.teacher_name = '李四'
) as c
on s.course_id = c.course_id
inner join student s2 on s.student_id = s2.student_id;

# 查询没学过李四老师所教的任何一门课的同学的学号，姓名
select distinct s.student_id, s2.student_name
from score s
inner join student s2 on s.student_id = s2.student_id
where s.course_id not in
(
    select c.course_id
    from course c
             inner join teacher t on c.teacher_id = t.teacher_id
    where t.teacher_name = '李四'
);

# 查询选修李四老师所授课程中的学生中成绩最高的学生姓名及其成绩
select s.student_id, s2.student_name, s.score
from score s
inner join student s2 on s.student_id = s2.student_id
where s.course_id not in
(
    select c.course_id
    from course c
             inner join teacher t on c.teacher_id = t.teacher_id
    where t.teacher_name = '李四'
)
order by s.score desc
limit 1;

# 查询至少有一门与学号为01的学生所学课程相同的学生的学号和姓名
select s2.student_id, s3.student_name
from
(
    select *
    from score
    where score.student_id = '01'
) as s1
inner join
(
    select *
    from score
    where score.student_id != '01'
) as s2
on s1.course_id = s2.course_id
inner join student s3 on s2.student_id = s3.student_id
group by s3.student_id;

# 按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩, 相当于是行转列
select
    s.student_id,
    max(if(c.course_name = '数学', score, 0)) as 数学,
    max(if(c.course_name = '语文', score, 0)) as 语文,
    max(if(c.course_name = '英语', score, 0)) as 英语,
    avg(s.score) as 平均分
from score s
inner join
course c on s.course_id = c.course_id
group by s.student_id;