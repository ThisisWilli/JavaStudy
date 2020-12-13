use MysqlExercise;
# 1.查询01课程比02课程高的学生的信息以及分数
# 思路：
# 1.1查询同时选修01课程和02课程学生的情况
select
       score1.student_id, stu.student_name, score1.course_id, score1.score as sco1,
       score2.course_id as cor2,
       score2.score as sco2
from
     (select * from scores where course_id='01') score1,
     (select * from scores where  course_id='02') score2,
     student stu
where score1.student_id=score2.student_id and stu.student_id=score2.student_id;

# 1.2查询存在选修了01课程但没有选修02课程的情况
# c1.S,c1.C cor1,c1.score sco1,c2.C cor2,c2.score scor2
select score1.student_id, score1.course_id, score1.score as sco1,
       score2.course_id as cou2,
       score2.score as scor2
from
    (select * from scores where course_id='01') score1
left join
    (select * from scores where course_id='02') score2
on score1.student_id=score2.student_id;

# 1.3查询不存在01课程但存在02课程的情况, 全部选出02的可能会包含也选修了01课程的学生
select * from scores where student_id not in
        (select student_id from scores where course_id='01') and course_id = 02;



# on后面的是连接条件，表示两表建立关系时所遵循的规则， on一般跟在join语句的后面
# where后面的可以看作筛选条件，是对最终结果集进行过滤时所遵循的规则
select scores1.student_id, stu1.student_name, scores1.score, scores2.score
from
    (select * from scores where course_id='01') scores1
left join
    (select * from scores where course_id='02') scores2
on scores1.student_id = scores2.student_id
join
    (select * from student) stu1
on scores1.student_id = stu1.student_id
where scores1.score > scores2.score or scores2.score is null;
