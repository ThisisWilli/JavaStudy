# 获取所有员工的emp_no、部门编号dept_no以及对应的bonus类型btype和received，没有分配奖金的员工不显示对应的bonus类型btype和received
use nowcoder;
select dept_emp.emp_no, dept_emp.dept_no, emp_bonus.btype, emp_bonus.received
from dept_emp
left join emp_bonus
on emp_bonus.emp_no = dept_emp.emp_no and dept_emp.to_date = '9999-01-01';