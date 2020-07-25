# 将employees表的所有员工的last_name和first_name拼接起来作为Name，中间以一个空格区分
use nowcoder;

select concat(concat(employees.last_name, ' '), employees.first_name) as Name
from employees;