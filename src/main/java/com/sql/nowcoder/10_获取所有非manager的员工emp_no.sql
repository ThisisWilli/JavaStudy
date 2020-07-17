# 获取所有非manager的员工emp;

use nowcoder;
select employees.emp_no
from employees
where employees.emp_no not in
(
    select dept_manager.emp_no
    from dept_manager
    ) ;