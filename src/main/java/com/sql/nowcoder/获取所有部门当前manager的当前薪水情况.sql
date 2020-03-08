use LeetCode;
CREATE TABLE `dept_manager` (
                                `dept_no` char(4) NOT NULL,
                                `emp_no` int(11) NOT NULL,
                                `from_date` date NOT NULL,
                                `to_date` date NOT NULL,
                                PRIMARY KEY (`emp_no`,`dept_no`));

select dept_manager.dept_no, dept_manager.dept_no, salaries.salary
from dept_manager
inner join salaries
on dept_manager.emp_no = salaries.emp_no and salaries.to_date = '9999-01-01';
select dept_manager.dept_no, dept_manager.dept_no, salaries.salary
from salaries
         inner join dept_manager
                    on dept_manager.emp_no = salaries.emp_no
                        and dept_manager.to_date = '9999-01-01'
                        and salaries.to_date = '9999-01-01'

