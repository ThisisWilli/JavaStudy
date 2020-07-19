# 查找所有员工的last_name和first_name以及对应的dept_name，也包括暂时没有分配部门的员工
use nowcoder;

CREATE TABLE `departments` (
                               `dept_no` char(4) NOT NULL,
                               `dept_name` varchar(40) NOT NULL,
                               PRIMARY KEY (`dept_no`));

select employees.last_name, employees.first_name, departments.dept_name
from employees
left join dept_emp
on employees.emp_no = dept_emp.emp_no
left join departments
on departments.dept_no = dept_emp.dept_no;