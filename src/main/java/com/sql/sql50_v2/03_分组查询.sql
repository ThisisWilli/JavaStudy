use mysql_exercise;

# 查询各科成绩最高和最低的分
select score.course_id, max(score.score) as max_score, min(score.score) as min_score
from score
group by score.course_id;


# 查询每门课程被选修的学生数
select score.course_id, count(score.student_id) as stu_num
from score
group by score.course_id;

# 查询男生、女生人数
select student.student_sex, count(student.student_id) as num
from student
group by student.student_sex;