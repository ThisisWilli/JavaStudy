# 请你写出更新语句，将所有获取奖金的员工当前的(salaries.to_date='9999-01-01')薪水增加10%。
# (emp_bonus里面的emp_no都是当前获奖的所有员工)
use nowcoder;
create table emp_bonus(
                          emp_no int not null,
                          btype smallint not null);

update salaries
set salaries.salary = salaries.salary * 1.1
where salaries.emp_no =  (
    select emp_no
    from emp_bonus
    )
and salaries.to_date = '9999-01-01';

