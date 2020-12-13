use mysql_exercise;

# 查询平均成绩大于60分学生的学号和平均成绩
select score.student_id, avg(score.score) as avg
from score
group by score.student_id
having avg > 60; # 对分组结果制定条件

# 查询至少选修两门课程的学生学号
select score.student_id
from score
group by score.student_id
having count(score.course_id) >= 3;

# 查询同名同姓学生名单并统计同名人数
select student.student_name, count(student.student_id) as num
from student
group by student.student_name
having num > 2;

# 查询不及格的课程并按照课程从大到小排序
select *
from score
where score.score < 60
order by score.course_id;

# 查询每门课程的平均成绩，结果按平均成绩升序排序，平均成绩相同时，按课程号降序排列
select score.course_id, avg(score.score) as avg
from score
group by score.course_id
order by avg, score.course_id desc;

# 检索课程编号为 04 且分数小于60的学生学号，结果安分数降序排列
select score.student_id
from score
where score.course_id = '04' and score.score < 60
order by score.score desc;

# 统计每门课程的学生选修人数，超过两人的课程才统计，要求输出课程号和选秀人数，查询结果按照人数降序排序，若人数相同， 按课程号升序排序
select score.course_id, count(score.student_id) as num
from score
group by score.course_id
having count(score.student_id)
order by num desc, score.course_id;

# 查询两门以上不及格课程的同学的学号及其平均成绩

select score.student_id, avg(score.score) as avg
from score
where score.score < 60
group by score.student_id
having count(score.score) > 2;




# select 查询结果 [姓名,人数：汇总函数count(*)]
# from 从哪张表中查找数据 [学生表student]
# where 查询条件 [没有]
# group by 分组 [姓名相同：按姓名分组]
# having 对分组结果指定条件 [姓名相同：count(*)>=2]
# order by 对查询结果排序[没有];


