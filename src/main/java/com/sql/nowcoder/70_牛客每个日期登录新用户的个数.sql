use nowcoder;
# 牛客每天有很多人登录，请你统计一下牛客每个日期登录新用户个数，
# 有一个登录(login)记录表，简况如下:


# 找到比当前日期早的所有user_id
select login.user_id
from login
where login.date < (select l2.date from login l2)
group by login.user_id;


# 当这个日期正好是这个用户登录的记录中的最小日期，那么这个用户肯定是新用户
select login.date, count(login.user_id) as new
from login
where login.date = (select min(l1.date) from login l1 group by l1.user_id);




select l0.date, ifnull(l3.new, 0)
from login l0
left join
(
    select l1.date, count(distinct l1.user_id) as new
    from login l1
    where l1.date =
        (
        select min(l2.date)
        from login l2
        where l1.user_id = l2.user_id
        group by l1.date)
)as l3
on l0.date = l3.date
group by l0.date
order by l0.date;

select login.date,ifnull(n1.new_num,0)
from login
left join
(
     select l1.date,count(distinct l1.user_id) as new_num
     from login l1
     where l1.date =
        (
            select min(date) from login where user_id=l1.user_id
        )
      group by l1.date) n1

on login.date = n1.date
group by login.date order by login.date