use LeetCode;
select emp_no, salary
from salaries
where to_date = '9999-01-01'
order by salary desc
limit 1 offset 1;