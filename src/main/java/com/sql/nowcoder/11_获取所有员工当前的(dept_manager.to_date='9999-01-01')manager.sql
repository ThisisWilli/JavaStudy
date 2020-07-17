# 获取所有员工当前的(dept_manager.to_date='9999-01-01')manager，
# 如果员工是manager的话不显示(也就是如果当前的manager是自己的话结果不显示)。输出结果第一列给出当前员工的emp_no,第二列给出其manager对应的emp_no。
use nowcoder;
select dept_emp.emp_no, dept_manager.emp_no as manager_no
from dept_emp
inner join dept_manager
on dept_emp.dept_no = dept_manager.dept_no and dept_manager.to_date = '9999-01-01' and dept_emp.emp_no != dept_manager.emp_no;