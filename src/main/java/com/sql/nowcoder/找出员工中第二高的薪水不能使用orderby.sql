use LeetCode;

select *
from salaries
where to_date='9999-01-01';
# group by to_date;



select s1.salary
from salaries as s1
inner join salaries as s2
on s1.to_date = '9999-01-01' and s2.to_date = '9999-01-01' and s1.salary <= s2.salary
group by s1.salary
having count(distinct s2.salary) = 2;

