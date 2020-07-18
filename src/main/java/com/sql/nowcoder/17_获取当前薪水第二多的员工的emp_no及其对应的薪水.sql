# 获取当前（to_date='9999-01-01'）薪水第二多的员工的emp_no以及其对应的薪水salary
use nowcoder;
select salaries.emp_no, salaries.salary
from salaries
where salaries.to_date = '9999-01-01'
order by salaries.salary desc
limit 1, 1