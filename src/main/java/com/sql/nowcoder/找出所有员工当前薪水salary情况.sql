# 找出所有员工当前(to_date='9999-01-01')具体的薪水salary情况，对于相同的薪水只显示一次,并按照逆序显示
use LeetCode;
select distinct salary
from salaries
where to_date = '9999-01-01'
order by salary desc;