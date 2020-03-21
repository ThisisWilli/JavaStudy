# 统计各个部门的工资记录数，给出部门编码dept_no、部门名称dept_name以及次数sum
select dept_emp.dept_no, departments.dept_name, count(dept_emp.dept_no) as sum
from departments, dept_emp, salaries

where departments.dept_no = dept_emp.dept_no and dept_emp.emp_no = salaries.emp_no
group by dept_emp.dept_no