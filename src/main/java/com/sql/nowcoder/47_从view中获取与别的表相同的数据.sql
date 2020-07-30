use nowcoder;
create view emp_v as select * from employees where emp_no >10005;
select em.*
from employees as em, emp_v as ev
where em.emp_no = ev.emp_no;