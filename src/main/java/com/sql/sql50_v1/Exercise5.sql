use MysqlExercise;
# 查询李姓老师的数量,count()是对行进行计数，模糊搜索时搭配的是%而不是*
select count(teacher.teacher_name)
from teacher
where teacher.teacher_name like '李%'