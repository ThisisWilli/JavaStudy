# 获取所有部门中当前员工薪水最高的相关信息
use LeetCode;
select dept_emp.dept_no, salaries.emp_no, max(salaries.salary) as salary
from salaries
inner join dept_emp
on salaries.emp_no = dept_emp.emp_no and salaries.to_date = '9999-01-01' and dept_emp.to_date = '9999-01-01'
group by dept_emp.dept_no;