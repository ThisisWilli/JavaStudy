# 获取所有非manager员工当前的薪水情况，给出dept_no、emp_no以及salary

use nowcoder;

select dept_emp.dept_no, salaries.emp_no, salaries.salary
from salaries, dept_emp
where salaries.to_date = '9999-01-01' and dept_emp.emp_no = salaries.emp_no and salaries.emp_no not in
    (
    select dept_manager.emp_no
    from dept_manager
    )