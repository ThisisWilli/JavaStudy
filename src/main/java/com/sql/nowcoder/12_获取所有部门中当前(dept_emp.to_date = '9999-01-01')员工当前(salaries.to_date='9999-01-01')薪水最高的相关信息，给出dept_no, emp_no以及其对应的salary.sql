# 获取所有部门中当前(dept_emp.to_date = '9999-01-01')员工当前(salaries.to_date='9999-01-01')薪水最高的相关信息，给出dept_no, emp_no以及其对应的salary
use nowcoder;

select dept_emp.dept_no, dept_emp.emp_no, max(salaries.salary)
from dept_emp
inner join salaries
on dept_emp.emp_no = salaries.emp_no and dept_emp.to_date = '9999-01-01' and salaries.to_date='9999-01-01'
group by dept_emp.dept_no;

select dept_emp.dept_no, dept_emp.emp_no, salaries.salary
from dept_emp
         inner join salaries
                    on dept_emp.emp_no = salaries.emp_no and dept_emp.to_date = '9999-01-01' and salaries.to_date='9999-01-01'
order by sa