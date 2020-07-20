# 查找所有员工自入职以来的薪水涨幅情况，给出员工编号emp_no以及其对应的薪水涨幅growth，并按照growth进行升序
# （注:可能有employees表和salaries表里存在记录的员工，有对应的员工编号和涨薪记录，但是已经离职了，离职的员工salaries表的最新的to_date!='9999-01-01'，
# 这样的数据不显示在查找结果里面）
use nowcoder;

select salaries.emp_no, min(salaries.from_date), salaries.salary
from salaries
group by salaries.emp_no;

select salaries.emp_no, salaries.salary
from salaries
where salaries.to_date = '9999-01-01';

select s1.emp_no, (s2.salary - s1.salary) as growth
from (select salaries.emp_no, min(salaries.from_date), salaries.salary
      from salaries
      group by salaries.emp_no) as s1
    inner join
    (
        select salaries.emp_no, salaries.salary
        from salaries
        where salaries.to_date = '9999-01-01'
        ) as s2
on s1.emp_no = s2.emp_no
order by growth