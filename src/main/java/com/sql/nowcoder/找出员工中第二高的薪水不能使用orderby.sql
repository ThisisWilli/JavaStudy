# 查找当前薪水(to_date='9999-01-01')排名第二多的员工编号emp_no、薪水salary、last_name以及first_name，不准使用order by
use LeetCode;
select *
from employees e
inner join salaries s
on e.emp_no = s.emp_no and to_date = '9999-01-01'
and s.salary =
    (
        select s1.salary
        from salaries s1, salaries s2
        where s1.salary <= s2.salary and s1.to_date = '9999-01-01' and  s2.to_date = '9999-01-01'
        group by s1.salary # 去重
        having count(distinct s2.salary) = 2
    )









