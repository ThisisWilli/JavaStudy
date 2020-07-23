# 给出每个员工每年薪水涨幅超过5000的员工编号emp_no、薪水变更开始日期from_date以及薪水涨幅值salary_growth，并按照salary_growth逆序排列。
# 提示：在sqlite中获取datetime时间对应的年份函数为strftime('%Y', to_date)
# (数据保证每个员工的每条薪水记录to_date-from_date=1年，而且同一员工的下一条薪水记录from_data=上一条薪水记录的to_data)
use nowcoder;

select s1.emp_no, s2.from_date, (s2.salary - s1.salary) as salary_growth
from salaries s1, salaries s2
where s1.emp_no = s2.emp_no and s1.to_date = s2.from_date and s2.salary - s1.salary > 5000
order by salary_growth desc;