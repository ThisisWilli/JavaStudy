use MysqlExercise;
# 查询没有学全所有课程的同学的信息
# 注意：count后面如果加了group by 那么就按group by中添加的列名中的成员信息来算数，不添加则按照select中的列名直接统计
select *
from
(select scores.student_id, count(scores.course_id) as choose_num from scores group by scores.student_id) as scores
join
(select count(course.course_id) as course_sum from course) as course
on course.course_sum != scores.choose_num

