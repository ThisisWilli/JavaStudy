# 将id=5以及emp_no=10001的行数据替换成id=5以及emp_no=10005,其他数据保持不变，使用replace实现。
use nowcoder;
update titles_test set titles_test.id = 5, titles_test.emp_no = 10001
where titles_test.id = 5 and titles_test.emp_no = 10005;