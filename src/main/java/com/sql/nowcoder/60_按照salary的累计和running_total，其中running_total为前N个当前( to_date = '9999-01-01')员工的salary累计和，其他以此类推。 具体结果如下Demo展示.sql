# 按照salary的累计和running_total，其中running_total为前N个当前( to_date = '9999-01-01')员工的salary累计和，
# 其他以此类推。 具体结果如下Demo展示
use nowcoder;


select s2.emp_no, s2.salary, sum(s1.salary) as running_total
from salaries s1, salaries s2
where s1.emp_no <= s2.emp_no
and s1.to_date = '9999-01-01'
and s2.to_date = '9999-01-01'
group by s2.emp_no;