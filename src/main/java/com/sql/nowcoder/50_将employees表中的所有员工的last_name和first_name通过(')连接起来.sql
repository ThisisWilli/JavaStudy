# 将employees表中的所有员工的last_name和first_name通过(')连接起来。(不支持concat，请用||实现)
use nowcoder;
select concat(concat(employees.last_name,'\''), employees.first_name) as name
from employees;