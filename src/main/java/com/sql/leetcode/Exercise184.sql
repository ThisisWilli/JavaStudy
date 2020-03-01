use LeetCode;
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Jim', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Max', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('6', 'Paul', '80000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');

select *
from Employee, Department
where Employee.DepartmentId = Department.Id
order by Salary desc ;

# 子查询和父查询有关，那么先执行子查询
select id, name, salary, departmentid
from Employee e1
where
2 >=
    (
        select count(distinct e2.Salary)
        from Employee e2
        where
              e1.Salary <= e2.Salary
          and e1.DepartmentId = e2.DepartmentId
    )
order by DepartmentId;

select * #distinct e1.Salary
from
     Employee e1,Employee e2
where e1.DepartmentId = e2.DepartmentId and e1.Salary < e2.Salary;
# order by e1.DepartmentId, e1.Salary desc ;

SELECT
    Department.name AS 'Department',
    Employee.name AS 'Employee',
    Salary
FROM
    Employee
        JOIN
    Department ON Employee.DepartmentId = Department.Id
where
      (Employee.DepartmentId, Salary) in
    (
    select DepartmentId, max(Salary)
    from Employee
    group by DepartmentId
    );




# e1=[6, 7, 8, 9, 9] e2=[6, 7, 8, 9, 9]
# e1 = 6, e2 = [7, 8, 9, 9] count = 3
# e1 = 7, e2 = [8, 9, 9] count = 2
# e1 = 8, e2 = [9, 9] count = 1
# e1 = 9, count = 0
# 如果3 > count 则e1可以取7，8，9相当于取出了前三大的数字


select *
# 1、拿到e1的数据
from Employee e1
where 1 =
    (
        select count(distinct e2.Salary)
        # e1派出哪几条数据和e2比能达到 where中的条件
        # 2、这里建立一张临时表拿到e2的数据，与e1的数据形成一张笛卡尔积表
        from Employee e2
        where e1.DepartmentId = e2.DepartmentId and e1.Salary <= e2.Salary
    )
order by DepartmentId;