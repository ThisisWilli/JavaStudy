# 对所有员工的当前(to_date='9999-01-01')薪水按照salary进行按照1-N的排名，相同salary并列且按照emp_no升序排列
use nowcoder;

select s1.emp_no,  count(s2.emp_no)
from salaries s1, salaries s2
where s1.salary < s2.salary and s1.to_date = '9999-01-01' and s2.to_date ='9999-01-01'
group by s1.emp_no;

select salaries.emp_no, salaries.salary, ss.rank_num as `rank`
from salaries inner join
    (
        select s1.emp_no,  count(distinct s2.salary) as rank_num
        from salaries s1, salaries s2
        where s1.salary <= s2.salary and s1.to_date = '9999-01-01' and s2.to_date ='9999-01-01'
        group by s1.emp_no
        ) as ss
where salaries.to_date = '9999-01-01' and salaries.emp_no = ss.emp_no
order by salaries.salary desc ;
