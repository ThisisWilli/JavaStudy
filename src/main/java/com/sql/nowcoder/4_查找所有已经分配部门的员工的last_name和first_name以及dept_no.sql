use nowcoder;
CREATE TABLE `dept_emp` (
                            `emp_no` int(11) NOT NULL,
                            `dept_no` char(4) NOT NULL,
                            `from_date` date NOT NULL,
                            `to_date` date NOT NULL,
                            PRIMARY KEY (`emp_no`,`dept_no`));

select employees.last_name, employees.first_name, dept_emp.dept_no
from employees
inner join dept_emp
on employees.emp_no = dept_emp.emp_no;