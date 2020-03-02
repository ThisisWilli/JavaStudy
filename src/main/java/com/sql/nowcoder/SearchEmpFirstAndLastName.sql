# 查找所有已经分配部门的员工的last_name和first_name以及dept_no
use nowcoder;
CREATE TABLE `dept_emp` (
                            `emp_no` int(11) NOT NULL,
                            `dept_no` char(4) NOT NULL,
                            `from_date` date NOT NULL,
                            `to_date` date NOT NULL,
                            PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `employees` (
                             `emp_no` int(11) NOT NULL,
                             `birth_date` date NOT NULL,
                             `first_name` varchar(14) NOT NULL,
                             `last_name` varchar(16) NOT NULL,
                             `gender` char(1) NOT NULL,
                             `hire_date` date NOT NULL,
                             PRIMARY KEY (`emp_no`));

# 查找所有已经分配部门的员工的last_name和first_name以及dept_no
insert employees values (10005, '1955-01-21', 'Kyoichi', 'Maliniak','M', '1989-09-10');
insert employees values (10006, '1955-01-22', 'cac', 'asda','M', '1989-08-12');
insert employees values (10007, '1955-01-23', 'jlkj', 'jklj','M', '1989-07-12');
insert employees values (10008, '1955-01-24', 'qweqeq', 'bmnxbcnm','M', '1989-06-12');
insert employees values (10009, '1955-01-24', 'qweqeq', 'bmnxbcnm','M', '1989-01-12');
