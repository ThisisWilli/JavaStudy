use interview;
create table student_score(
    name varchar(50),
    course_name varchar(50),
    score int
)character set = utf8;

insert into student_score
values ('张三', '语文', 80),
       ('张三', '数学', 90),
       ('张三', '英语', 70),

       ('李四', '语文', 70),
       ('李四', '数学', 60),
       ('李四', '英语', 50),

       ('王五', '语文', 100),
       ('王五', '数学', 30),
       ('王五', '英语', 70);



select s1.name, s1.course_name, s1.score
from
student_score as s1
inner join
(
    select student_score.name, max(student_score.score) as highest_grade
    from student_score
    group by student_score.name
) as s2
on s1.name = s2.name and s1.score = s2.highest_grade;

select s1.name, s1.course_name, s1.score
from student_score s1, student_score s2
where s1.name = s2.name and s1.score <= s2.score
group by s1.name, s1.score
having count(s2.course_name) = 1;