# 获取所有部门当前(dept_manager.to_date='9999-01-01')manager的当前(salaries.to_date='9999-01-01')薪水情况，
# 给出dept_no, emp_no以及salary(请注意，同一个人可能有多条薪水情况记录)
use nowcoder;
select dept_manager.dept_no, dept_manager.emp_no, salaries.salary
from dept_manager
inner join salaries
on dept_manager.to_date = '9999-01-01' and salaries.to_date = '9999-01-01' and dept_manager.emp_no = salaries.emp_no;