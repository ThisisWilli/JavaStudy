use mysql_exercise;

# 查询学生的总成绩并进行排名
select score.student_id, sum(score.score) as sum
from score
group by score.student_id
order by sum;

# 查询平均成绩大于60的学生的学号和平均成绩
select score.student_id, avg(score.score) as avg
from score
group by score.student_id
having avg > 60;

# 查询所有课程成绩小于60分学生的学号、姓名
select *
from
(
    select score.student_id, count(score.student_id) as sum_course_num
    from score
    group by score.student_id) as s1
inner join
(
    select score.student_id, count(score.student_id) as low_than_60
    from score
    where score.score < 60
group by score.student_id) as s2
where s1.student_id = s2.student_id and s1.sum_course_num = s2.low_than_60;


# 查询没有学全所有课的学生的学号，姓名
select s.student_id, student.student_name
from
(
    select score.student_id, count(score.student_id) as choose_num
    from score
    group by score.student_id
) as s
inner join student
on s.student_id = student.student_id and s.choose_num < (select count(course.course_id) as course_num from course);


# 查询只选修了两门课程的全部学生的学号和姓名
select s.student_id, student.student_name
from
(
    select score.student_id, count(score.student_id) as choose_two
    from score
    group by score.student_id
    having choose_two = 2
) as s
inner join student
on s.student_id = student.student_id