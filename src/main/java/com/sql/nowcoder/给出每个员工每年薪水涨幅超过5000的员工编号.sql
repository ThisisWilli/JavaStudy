use nowcoder;
select s1.emp_no, s2.from_date, s2.salary - s1.salary as salary_growth
from salaries s1, salaries s2
where s1.emp_no = s2.emp_no and strftime('%Y', s2.to_date)-strftime('%Y', s1.to_date)=1 and s2.salary - s1.salary > 5000
order by salary_growth desc