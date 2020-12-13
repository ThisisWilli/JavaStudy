# 查询1990年出生的人
use MysqlExercise;
select *
from student where student_age like '1990%';