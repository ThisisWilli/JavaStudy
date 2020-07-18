# 统计出当前(titles.to_date='9999-01-01')各个title类型对应的员工当前(salaries.to_date='9999-01-01')
# 薪水对应的平均工资。结果给出title以及平均工资avg。
use nowcoder;

select titles.title, avg(salaries.salary) as avg
from titles, salaries
where titles.emp_no = salaries.emp_no and titles.to_date = '9999-01-01' and salaries.to_date = '9999-01-01'
group by titles.title;