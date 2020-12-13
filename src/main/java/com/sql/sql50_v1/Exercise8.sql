use MysqlExercise;
# 查询至少有一门课与学号为01的同学所学相同的同学的信息
# 看到不同，想到distinct， in通常和where通用，表示查询某个范围内的数据
select s.student_id,s.student_name from student s , scores
where s.student_id = scores.student_id and course_id
in (select course_id from scores where s.student_id=01)


