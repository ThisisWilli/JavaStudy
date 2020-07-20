# 统计各个部门的工资记录数，给出部门编码dept_no、部门名称dept_name以及部门在salaries表里面有多少条记录sum
use nowcoder;

select dept_emp.dept_no, departments.dept_name, count(*) as sum
from salaries, dept_emp, departments
where salaries.emp_no = dept_emp.emp_no and dept_emp.dept_no = departments.dept_no
group by dept_emp.dept_no, departments.dept_name;