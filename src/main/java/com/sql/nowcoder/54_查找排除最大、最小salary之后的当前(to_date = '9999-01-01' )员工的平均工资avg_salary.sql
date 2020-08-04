# 查找排除最大、最小salary之后的当前(to_date = '9999-01-01' )员工的平均工资avg_salary。
use nowcoder;
select salaries.emp_no, max(salaries.salary), min(salaries.salary)
from salaries
where salaries.to_date = '9999-01-01'

select salaries.emp_no, min(salaries.salary)
from salaries
where salaries.to_date = '9999-01-01';

select avg(salaries.salary) as avg_salary
from salaries
where salaries.emp_no !=
      (
          select s1.emp_no from
          (select salaries.emp_no, min(salaries.salary)
                          from salaries
                          where salaries.to_date = '9999-01-01')
          as s1

          )  and salaries.emp_no !=
                (
                    select s2.emp_no from
                    (select salaries.emp_no, max(salaries.salary)
                    from salaries
                    where salaries.to_date = '9999-01-01') as s2
                    )
and salaries.to_date = '9999-01-01'