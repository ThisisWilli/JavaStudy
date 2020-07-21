# 获取员工其当前的薪水比其manager当前薪水还高的相关信息，当前表示to_date='9999-01-01',
# 结果第一列给出员工的emp_no，
# 第二列给出其manager的manager_no，
# 第三列给出该员工当前的薪水emp_salary,
# 第四列给该员工对应的manager当前的薪水manager_salary

use nowcoder;

# 员工部门领导的薪水
select salaries.salary
from salaries, dept_manager
where salaries.emp_no = dept_manager.emp_no and salaries.to_date = '9999-01-01' and dept_manager.to_date = '9999-01-01';

# 每个非manager员工的薪水的当前薪水
select salaries.salary
from salaries
where salaries.emp_no not in
      (
          select dept_manager.emp_no
          from dept_manager
          where dept_manager.to_date = '9999-01-01'
       ) and salaries.to_date = '9999-01-01';




select emp.emp_no as emp_no, manager.emp_no as manager_no, emp.salary as emp_salary, manager.salary as manager_salary
from
    (
    select salaries.emp_no, salaries.salary, dept_manager.dept_no
    from salaries, dept_manager
    where salaries.emp_no = dept_manager.emp_no and salaries.to_date = '9999-01-01' and dept_manager.to_date = '9999-01-01'
    ) as manager
inner join
        (
            select salaries.emp_no, salaries.salary, dept_emp.dept_no
            from salaries, dept_emp
            where salaries.emp_no = dept_emp.emp_no and salaries.emp_no not in
                  (
                      select dept_manager.emp_no
                      from dept_manager
                      where dept_manager.to_date = '9999-01-01'
                  ) and salaries.to_date = '9999-01-01'
            ) as emp
where emp.salary > manager.salary and emp.dept_no = manager.dept_no;