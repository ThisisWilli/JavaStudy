# 查找员工编号emp_no为10001其自入职以来的薪水salary涨幅(总共涨了多少)growth(可能有多次涨薪，没有降薪)
use nowcoder;
select
(
    (select salaries.salary
    from salaries
    where salaries.to_date = '9999-01-01' and salaries.emp_no = 10001)
    -
    (
        select salaries.salary
        from salaries
        where salaries.from_date = (
            select min(from_date)
            from salaries
            where salaries.emp_no = 10001
            )
        )
) as growth
