CREATE TABLE `salaries` (
                            `emp_no` int(11) NOT NULL,
                            `salary` int(11) NOT NULL,
                            `from_date` date NOT NULL,
                            `to_date` date NOT NULL,
                            PRIMARY KEY (`emp_no`,`from_date`));


select s1.emp_no, count(s1.emp_no) + 1 as t
from salaries as s1, salaries as s2
where s1.from_date = s2.to_date and s1.emp_no = s2.emp_no and s1.salary > s2.salary
group by s1.emp_no
having t >= 16;