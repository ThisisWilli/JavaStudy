use MysqlExercise;
# 检索01课程分数小于60，按分数降序排列的学生信息
# asc表示升序排序，desc表示降序排序
select *
from scores, student where course_id = '01' and scores.student_id = student.student_id
having score < 60
order by score desc ;