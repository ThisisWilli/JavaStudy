use nowcoder;
# 对所有员工的当前(to_date='9999-01-01')薪水按照salary进行按照1-N的排名，相同salary并列且按照emp_no升序排列







select  a.emp_no ,a.salary,count(distinct b.salary) as rank
from salaries as a,salaries as b
where a.to_date = '9999-01-01' and b.to_date ='9999-01-01' and a.salary<= b.salary
group by a.emp_no
order by a.salary desc, a.emp_no;