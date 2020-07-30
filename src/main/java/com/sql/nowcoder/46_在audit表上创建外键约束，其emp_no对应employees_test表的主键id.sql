# 46 在audit表上创建外键约束，其emp_no对应employees_test表的主键id。
# (audit已经创建，需要先drop)
use nowcoder;
alter table audit
add foreign key(EMP_no) references employees_test(ID);