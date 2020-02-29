show databases;
use nowcoder;
CREATE TABLE `employees` (
                             `emp_no` int(11) NOT NULL,
                             `birth_date` date NOT NULL,
                             `first_name` varchar(14) NOT NULL,
                             `last_name` varchar(16) NOT NULL,
                             `gender` char(1) NOT NULL,
                             `hire_date` date NOT NULL,
                             PRIMARY KEY (`emp_no`));
insert employees values (10005, '1955-01-21', 'Kyoichi', 'Maliniak','M', '1989-09-10');
insert employees values (10006, '1955-01-22', 'cac', 'asda','M', '1989-08-12');
insert employees values (10007, '1955-01-23', 'jlkj', 'jklj','M', '1989-07-12');
insert employees values (10008, '1955-01-24', 'qweqeq', 'bmnxbcnm','M', '1989-06-12');
insert employees values (10009, '1955-01-24', 'qweqeq', 'bmnxbcnm','M', '1989-01-12');

# 查找入职员工时间排名倒数第三的员工所有信息

select *
from employees
order by hire_date desc
limit 2, 1;