# 获取所有非manager员工当前的薪水情况，给出dept_no、emp_no以及salary ，当前表示to_date='9999-01-01'
use nowcoder;

CREATE TABLE `dept_manager` (
                                `dept_no` char(4) NOT NULL,
                                `emp_no` int(11) NOT NULL,
                                `from_date` date NOT NULL,
                                `to_date` date NOT NULL,
                                PRIMARY KEY (`emp_no`,`dept_no`));

select dept_emp.dept_no, dept_emp.emp_no, salaries.salary
from dept_emp, salaries
where dept_emp.emp_no = salaries.emp_no
  and dept_emp.to_date = '9999-01-01'
  and salaries.to_date = '9999-01-01'
  and dept_emp.emp_no not in
    (
        select dept_manager.emp_no
        from dept_manager
        );