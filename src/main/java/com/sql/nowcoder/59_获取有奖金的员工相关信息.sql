# 获取有奖金的员工相关信息。给出emp_no、first_name、last_name、奖金类型btype、对应的当前薪水情况salary以及奖金金额bonus。
# bonus类型btype为1其奖金为薪水salary的10%，btype为2其奖金为薪水的20%，其他类型均为薪水的30%。 当前薪水表示to_date='9999-01-01'
# CREATE TABLE `employees` (
#                              `emp_no` int(11) NOT NULL,
#                              `birth_date` date NOT NULL,
#                              `first_name` varchar(14) NOT NULL,
#                              `last_name` varchar(16) NOT NULL,
#                              `gender` char(1) NOT NULL,
#                              `hire_date` date NOT NULL,
#                              PRIMARY KEY (`emp_no`));
# CREATE TABLE `dept_emp` (
#                             `emp_no` int(11) NOT NULL,
#                             `dept_no` char(4) NOT NULL,
#                             `from_date` date NOT NULL,
#                             `to_date` date NOT NULL,
#                             PRIMARY KEY (`emp_no`,`dept_no`));
# create table emp_bonus(
#                           emp_no int not null,
#                           received datetime not null,
#                           btype smallint not null);
# CREATE TABLE `salaries` (
#                             `emp_no` int(11) NOT NULL,
#                             `salary` int(11) NOT NULL,
#                             `from_date` date NOT NULL,
#                             `to_date` date NOT NULL, PRIMARY KEY (`emp_no`,`from_date`));
# 给出emp_no、first_name、last_name、奖金类型btype、对应的当前薪水情况salary以及奖金金额bonus。 bonus类型btype为1其奖金为薪水salary的10%，btype为2其奖金为薪水的20%，其他类型均为薪水的30%。 当前薪水表示to_date='9999-01-01'
# 输出格式:
# emp_no	first_name	last_name	btype	salary	bonus

use nowcoder;
#不要忘记筛选条件，工资要求是当前工资
select e.emp_no,first_name,last_name,btype,salary,(
    case
                                                       when btype=1 then salary*0.1
                                                       when btype=2 then salary*0.2
                                                       else salary*0.3
    end) as bonus
from employees e
         inner join emp_bonus b on e.emp_no=b.emp_no
         inner join salaries s on e.emp_no=s.emp_no
where s.to_date='9999-01-01';
