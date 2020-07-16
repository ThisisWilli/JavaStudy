# 查找薪水变动超过15次的员工号emp_no以及其对应的变动次数t
use nowcoder;

select a.emp_no, count(*) as t
from salaries as a
inner join salaries as b
on a.emp_no = b.emp_no and a.to_date = b.from_date
where a.salary < b.salary
group by a.emp_no
having t > 15;
