use nowcoder;
create table emp_bonus(
                          emp_no int not null,
                          recevied datetime not null,
                          btype smallint not null);
CREATE TABLE `salaries` (
                            `emp_no` int(11) NOT NULL,
                            `salary` int(11) NOT NULL,
                            `from_date` date NOT NULL,
                            `to_date` date NOT NULL, PRIMARY KEY (`emp_no`,`from_date`));
update salaries set salaries.salary = salaries.salary * 1.1 where salaries.emp_no in (select emp_no from emp_bonus) and salaries.to_date = '9999-01-01'


update salaries set salary=salary*1.1 where emp_no in (
    select emp_no from emp_bonus
) and to_date='9999-01-01'