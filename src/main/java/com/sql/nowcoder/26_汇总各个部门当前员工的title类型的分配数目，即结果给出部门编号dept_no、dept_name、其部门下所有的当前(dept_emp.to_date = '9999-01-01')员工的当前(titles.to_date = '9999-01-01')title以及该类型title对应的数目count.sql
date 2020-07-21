# 汇总各个部门当前员工的title类型的分配数目，即结果给出部门编号dept_no、dept_name、其部门下所有的当前(dept_emp.to_date = '9999-01-01')
# 员工的当前(titles.to_date = '9999-01-01')title以及该类型title对应的数目count
# (注：因为员工可能有离职，所有dept_emp里面to_date不为'9999-01-01'就已经离职了，不计入统计，
# 而且员工可能有晋升，所以如果titles.to_date 不为 '9999-01-01'，那么这个可能是员工之前的职位信息，也不计入统计)

use nowcoder;

select dept_emp.emp_no, count(titles.title) as count, titles.title
from dept_emp, titles
where dept_emp.emp_no = titles.emp_no and dept_emp.to_date = '9999-01-01' and titles.to_date = '9999-01-01'
group by dept_emp.emp_no;

select s1.dept_no, d.dept_name, s1.title, s1.count
from
(
    select dept_emp.dept_no, titles.title, count(titles.title) as count
    from dept_emp, titles
    where dept_emp.to_date = '9999-01-01' and titles.to_date = '9999-01-01' and dept_emp.emp_no = titles.emp_no
    group by dept_emp.dept_no, titles.title
    ) as s1
inner join (
    select departments.dept_no, departments.dept_name
    from departments
    ) as d
where s1.dept_no = d.dept_no;