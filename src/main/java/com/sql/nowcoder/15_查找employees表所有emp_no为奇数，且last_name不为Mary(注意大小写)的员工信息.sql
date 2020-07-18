use nowcoder;
select emp_no, birth_date, first_name, last_name, gender, hire_date
from employees
where last_name != "Mary" and (employees.emp_no & 1) = 1
order by hire_date desc;