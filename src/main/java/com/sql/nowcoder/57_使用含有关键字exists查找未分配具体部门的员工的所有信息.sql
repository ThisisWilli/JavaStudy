use nowcoder;
select *
from employees
where employees.emp_no not in(select dept_emp.emp_no from dept_emp);