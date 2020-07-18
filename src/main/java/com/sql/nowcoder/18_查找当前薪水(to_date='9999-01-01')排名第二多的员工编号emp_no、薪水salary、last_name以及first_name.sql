# 查找当前薪水(to_date='9999-01-01')排名第二多的员工编号emp_no、薪水salary、last_name以及first_name，你可以不使用order by完成吗
use nowcoder;

select salaries.emp_no, salaries.salary, employees.last_name, employees.first_name
from salaries, employees
where salaries.to_date = '9999-01-01'
order by salaries.salary desc
limit 1, 1;

select salaries.emp_no, max(salaries.salary) as salary, employees.last_name, employees.first_name
from salaries, employees
where salaries.emp_no not in
(
    select salaries.emp_no
    from salaries
    where salaries.to_date = '9999-01-01' and salaries.salary = (
        select max(salaries.salary)
        from salaries
        )
) and salaries.emp_no = employees.emp_no and salaries.to_date = '9999-01-01';

select e.emp_no,s.salary,e.last_name,e.first_name
from
    employees e
        join
    salaries s on e.emp_no=s.emp_no
        and  s.to_date='9999-01-01'
        and s.salary =
            (
                select s1.salary
                from
                    salaries s1, salaries s2
                where s1.salary<=s2.salary and s1.to_date='9999-01-01' and s2.to_date='9999-01-01'
                group by s1.salary
                having count(distinct s2.salary)=2
            );

select  s1.salary
from
    salaries s1, salaries s2
where s1.salary<=s2.salary and s1.to_date='9999-01-01' and s2.to_date='9999-01-01'
group by s1.salary
having count(distinct s2.salary)=2