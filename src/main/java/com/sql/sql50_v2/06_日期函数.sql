use mysql_exercise;

# 查询各学生的年龄(精确到月份)
# 语法：
# TIMESTAMPDIFF(interval,datetime_expr1,datetime_expr2)。
# 说明： 返回日期或日期时间表达式datetime_expr1 和datetime_expr2the 之间的整数差。其结果的单位由interval 参数给出。该参数必须是以下值的其中一个：
# FRAC_SECOND。表示间隔是毫秒
# SECOND。秒
# MINUTE。分钟
# HOUR。小时
# DAY。天
# WEEK。星期
# MONTH。月
# QUARTER。季度
# YEAR。年
select student.student_id, timestampdiff(month , student.student_birth, now()) / 12
from student;

# 查询本月过生日的同学

select *
from student
where month(student.student_birth) = month(now());