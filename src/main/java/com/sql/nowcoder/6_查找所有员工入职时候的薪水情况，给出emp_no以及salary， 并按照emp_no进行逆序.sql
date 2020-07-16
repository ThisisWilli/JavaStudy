# 查找所有员工入职时候的薪水情况，给出emp_no以及salary， 并按照emp_no进行逆序(请注意，一个员工可能有多次涨薪的情况)

use nowcoder;

select s1.emp_no, s1.salary
from salaries as s1
inner join
    (
          select emp_no, min(from_date) as hire
          from salaries
          group by emp_no
    ) as s2
on s1.emp_no = s2.emp_no and s1.from_date = s2.hire
order by s1.emp_no desc;

