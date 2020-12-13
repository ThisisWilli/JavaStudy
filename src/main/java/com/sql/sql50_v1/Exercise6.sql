use MysqlExercise;
# 查询上过张三老师课的学生的信息
# 先从teacher这张表中的teacher_id对应course中的teacher_id，进而得到course_id,
# 再从course中的course_id得到student_id，最后从student表中得到student_name
select scores.student_id, student.student_name,teacher.teacher_id, teacher.teacher_name, course.course_id, course.course_name
from
    (select teacher.teacher_id, teacher.teacher_name from teacher) as teacher
join
    (select * from course) as course
join
    (select * from scores) as scores
join
    (select student.student_id, student.student_name from student) as student
where teacher.teacher_name = '张三' and course.teacher_id = teacher.teacher_id and
                    scores.course_id = course.course_id and student.student_id = scores.student_id;

select student.student_name, student.student_id from student