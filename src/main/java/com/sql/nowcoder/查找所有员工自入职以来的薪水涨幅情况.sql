use LeetCode;

select
    (
        select s1.salary
        from salaries as s1
        order by emp_no, from_date
    );

select s1.emp_no, s1.salary
from salaries as s1
inner join
      (
          select emp_no,min(from_date) as min
          from salaries as s1
          group by emp_no
          ) as s2
on s1.emp_no = s2.emp_no and s1.from_date = s2.min;

select salaries.emp_no, salaries.salary
from salaries
where salaries.to_date = '9999-01-01';


select ss1.emp_no, (ss2.salary - ss1.salary) as growth
from
    (
        select s.emp_no, s.salary
        from employees as e, salaries as s
        where e.emp_no = s.emp_no and e.hire_date = s.from_date
    ) as ss1
    inner join
    (
        select salaries.emp_no, salaries.salary
        from salaries
        where salaries.to_date = '9999-01-01'
    ) as ss2
on ss1.emp_no = ss2.emp_no
order by growth



select s1.emp_no, s1.salary
from salaries as s1
         inner join
     (
         select emp_no,min(from_date) as min
         from salaries as s1
         group by emp_no
     ) as s2
     on s1.emp_no = s2.emp_no and s1.from_date = s2.min

