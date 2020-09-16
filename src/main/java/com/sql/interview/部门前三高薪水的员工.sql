create database interview;
use interview;
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '85000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Janet', '69000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('6', 'Randy', '85000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('7', 'Will', '70000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');


select te.DepartmentId, te.Salary,
       case
            when @pre = DepartmentId then @rank := @`rank` + 1
            when @pre := DepartmentId then @`rank` := 1
        end
from
    (select @pre := null, @rank := 0) as tt,
    (
        select Employee.DepartmentId, Employee.Salary
        from Employee
        group by Employee.DepartmentId, Employee.Salary
        order by Employee.DepartmentId, Employee.Salary DESC
    ) as te;

select Department.Name as Department, table1.Name as Employee, table1.Salary as Salary
from
(
    select result.Id, result.Name ,result.Salary, result.DepartmentId, result.`rank`
    from
    (
        select
           Id,
           Name,
           Salary,
           DepartmentId,
           case
               when @pre = DepartmentId and @last_salary != Salary then @`rank` := @`rank` + 1
               when @pre = DepartmentId and @last_salary = Salary then @`rank`:= @`rank`
               when @pre := DepartmentId then @rank := 1
               end as `rank`,
           @last_salary := Salary
        from
        (select @pre := null, @rank := 0, @last_salary := 0) as tt,
        (select Employee.Id, Employee.Name, Employee.Salary, Employee.DepartmentId from Employee
        order by Employee.DepartmentId, Employee.Salary desc) as te
    ) as result
) as table1
inner join Department
on Department.Id = table1.DepartmentId and table1.`rank` <= 3;