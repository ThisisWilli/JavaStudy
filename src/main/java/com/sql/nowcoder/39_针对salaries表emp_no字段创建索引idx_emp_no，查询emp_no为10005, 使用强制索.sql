# 针对salaries表emp_no字段创建索引idx_emp_no，查询emp_no为10005, 使用强制索引
use nowcoder;
select *
from salaries force index idx_emp_no
where emp_no = 10005;

SELECT *
FROM salaries
FORCE INDEX idx_emp_no
WHERE emp_no = 10005