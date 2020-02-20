use MysqlExercise;
Create table If Not Exists courses (student varchar(255), class varchar(255))
Truncate table courses;
insert into courses (student, class) values ('A', 'Math');
insert into courses (student, class) values ('B', 'English');
insert into courses (student, class) values ('C', 'Math');
insert into courses (student, class) values ('D', 'Biology');
insert into courses (student, class) values ('E', 'Math');
insert into courses (student, class) values ('F', 'Computer');
insert into courses (student, class) values ('G', 'Math');
insert into courses (student, class) values ('H', 'Math');
insert into courses (student, class) values ('I', 'Math');

select *
from courses;

select class
from
    (
        select class, count(distinct student) as classNum
        from courses
        group by class
    ) as minicourses
where classNum >= 5
