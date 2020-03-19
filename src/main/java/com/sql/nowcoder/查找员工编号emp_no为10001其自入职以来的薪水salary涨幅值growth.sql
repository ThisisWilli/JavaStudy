use LeetCode;

select
    (
        (
            select s2.salary
            from salaries as s2
            where s2.to_date ='9999-01-01' and s2.emp_no = 10001
            ) -
        (
        select s1.salary
        from salaries as s1
        where s1.emp_no = 10001
        order by s1.to_date
        limit 1
        )
) as growth
;

select salary
from salaries
where salaries.emp_no = 10001
order by salaries.to_date
limit 1;

select salary
from salaries
where salaries.to_date ='9999-01-01' and salaries.emp_no = 10001;