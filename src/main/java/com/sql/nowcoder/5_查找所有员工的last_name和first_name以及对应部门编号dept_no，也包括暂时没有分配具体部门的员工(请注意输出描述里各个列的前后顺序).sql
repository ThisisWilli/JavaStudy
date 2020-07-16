use nowcoder;
select employees.last_name, employees.first_name, dept_emp.dept_no
from employees
left join dept_emp
on employees.emp_no = dept_emp.emp_no;