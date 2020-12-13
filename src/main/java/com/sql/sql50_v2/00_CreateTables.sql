use mysql_exercise;
create table student(
    student_id varchar(10),
    student_name varchar(10),
    student_birth datetime,
    student_sex varchar(10))engine = InnoDB, default character set = utf8mb4;;
insert into student values('01' , '赵雷' , '1990-01-01' , '男');
insert into student values('02' , '钱电' , '1990-12-21' , '男');
insert into student values('03' , '孙风' , '1990-05-20' , '男');
insert into student values('04' , '李云' , '1990-08-06' , '男');
insert into student values('05' , '周梅' , '1991-12-01' , '女');
insert into student values('06' , '吴兰' , '1992-03-01' , '女');
insert into student values('07' , '郑竹' , '1989-07-01' , '女');
insert into student values('08' , '王菊' , '1990-01-20' , '女');

create table course(
    course_id varchar(10),
    course_name varchar(10),
    teacher_id varchar(10))engine = InnoDB, default character set = utf8mb4;;
insert into course values('01' , '语文' , '02');
insert into course values('02' , '数学' , '01');
insert into course values('03' , '英语' , '03');

create table teacher(
    teacher_id varchar(10),
    teacher_name varchar(10))engine = InnoDB, default character set = utf8mb4;;
insert into teacher values('01' , '张三');
insert into teacher values('02' , '李四');
insert into teacher values('03' , '王五');

create table score(
    score_id varchar(10),
    course_id varchar(10),
    score decimal(18,1))engine = InnoDB, default character set = utf8mb4;;
insert into score values('01' , '01' , 80);
insert into score values('01' , '02' , 90);
insert into score values('01' , '03' , 99);
insert into score values('02' , '01' , 70);
insert into score values('02' , '02' , 60);
insert into score values('02' , '03' , 80);
insert into score values('03' , '01' , 80);
insert into score values('03' , '02' , 80);
insert into score values('03' , '03' , 80);
insert into score values('04' , '01' , 50);
insert into score values('04' , '02' , 30);
insert into score values('04' , '03' , 20);
insert into score values('05' , '01' , 76);
insert into score values('05' , '02' , 87);
insert into score values('06' , '01' , 31);
insert into score values('06' , '03' , 34);
insert into score values('07' , '02' , 89);
insert into score values('07' , '03' , 98);
select * from student;
select * from course;
select * from teacher;
select * from score;

drop table student;
drop table course;
drop table teacher;
drop table score;

# 修改列名 ===== ALTER  TABLE 表名 CHANGE [column] 旧字段名 新字段名 新数据类型;
alter table score change column score_id student_id varchar(10);
