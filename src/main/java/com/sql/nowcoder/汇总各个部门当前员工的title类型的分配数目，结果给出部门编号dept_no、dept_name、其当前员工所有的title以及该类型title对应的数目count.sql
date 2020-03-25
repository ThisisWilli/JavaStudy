# 汇总各个部门当前员工的title类型的分配数目，结果给出部门编号dept_no、dept_name、其当前员工所有的title以及该类型title对应的数目count
use nowcoder;
CREATE TABLE IF NOT EXISTS `titles` (
                                        `emp_no` int(11) NOT NULL,
                                        `title` varchar(50) NOT NULL,
                                        `from_date` date NOT NULL,
                                        `to_date` date DEFAULT NULL);

select departments.dept_no, departments.dept_name, titles.title, count(titles.title)
from titles, dept_emp, departments
where titles.emp_no = dept_emp.emp_no and dept_emp.dept_no = departments.dept_no and titles.to_date = '9999-01-01' and dept_emp.to_date = '9999-01-01'
group by departments.dept_no;