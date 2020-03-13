use LeetCode;
select *
from employees
where mod(employees.emp_no, 2) = 1 and employees.last_name != 'Mary'
order by employees.hire_date desc