use MysqlExercise;
# 查询各科成绩最高分，最低分和平均分
#以如下形式显示：课程 ID，课程 name，最高分，最低分，平均分，及格率，中等率，优良率，
#              优秀率 (及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90)
select scores.course_id as '课程id', course.course_name as '课程',
       max(score) as '最高分', min(score) as '最低分', avg(score) as '平均分', count(*) as '选修人数',
        (sum(if(score>=60,1,0))/count(student_id))及格率,
       (sum(if(score<80 and score>=70,1,0))/count(student_id))中等率,
       (sum(if(score<90 and score =80,1,0))/count(student_id))优良率,
       (sum(if(score>=90,1,0))/count(student_id))优秀率
from scores, course
group by scores.course_id, course.course_name
order by 选修人数 desc , scores.course_id asc ;