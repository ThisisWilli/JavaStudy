# 对于employees表中，输出first_name排名(按first_name升序排序)为奇数的first_name
# 对于employees表中，输出first_name排名(按first_name升序排序)为奇数的first_name
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

INSERT INTO employees VALUES(10001,'1953-09-02','Georgi','Facello','M','1986-06-26');
INSERT INTO employees VALUES(10002,'1964-06-02','Bezalel','Simmel','F','1985-11-21');
INSERT INTO employees VALUES(10005,'1955-01-21','Kyoichi','Maliniak','M','1989-09-12');
INSERT INTO employees VALUES(10006,'1953-04-20','Anneke','Preusig','F','1989-06-02');
use nowcoder;

select e2.emp_no, e2.first_name, count(e1.emp_no) as rank_num
from employees e1, employees e2
where e1.first_name > e2.first_name
group by e1.emp_no
having rank_num % 2 = 1
order by rank_num;



select *
from employees
where employees.emp_no = (
    select s1.first_name
    from (
             select e2.emp_no, e2.first_name, count(e1.emp_no) as rank_num
             from employees e1, employees e2
             where e1.first_name > e2.first_name
             group by e1.emp_no
             having rank_num % 2 = 1
             order by rank_num
             ) as s1
    );


select e1.first_name
from employees e1
where (
          select count(*)
          from employees e2
          where (e1.first_name <= e2.first_name)
          ) % 2 = 1;

SELECT e1.first_name FROM
    employees e1
WHERE
            (SELECT count(*) FROM employees e2
             WHERE e1.first_name <=e2.first_name)%2=1;
