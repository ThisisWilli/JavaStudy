use nowcoder;
# 牛客每天有很多人登录，请你统计一下牛客每个日期登录新用户个数，
# 有一个登录(login)记录表，简况如下:

select *
from login;

# 找到比当前日期早的所有user_id
select login.user_id
from login
where login.date < (select l2.date from login l2)
group by login.user_id;


# 当这个日期正好是这个用户登录的记录中的最小日期，那么这个用户肯定是新用户
select login.date, count(login.user_id) as new
from login
where login.date = (select min(l1.date) from login l1 group by l1.user_id);




select login.date,ifnull(n1.new_num,0) as new_num
from login
         left join
     (select l1.date,count(distinct l1.user_id) as new_num
      from login l1
      where l1.date =
            (select min(date) from login where user_id=l1.user_id)
      group by l1.date) n1
     on login.date = n1.date
group by login.date order by login.date;

# 先找出当前这个日期之前出现过的用户id号
select distinct l1.user_id, l2.date
from login l1, login l2
where l2.date > l1.date;

# 然后两张表进行比较
select l1.date, if(count(l1.user_id) > 0, count(l1.user_id), 0)  as new
from login as l1
where l1.user_id not in(
    select distinct l2.user_id
    from login as l2
    where l2.date < l1.date
    )
group by l1.date


select distinct l0.date, (case when l3.new is null then 0 else l3.new end ) as new
from login as l0
left join (
    select l1.date, count(l1.user_id)  as new
    from login as l1
    where l1.user_id not in(
        select distinct l2.user_id
        from login as l2
        where l2.date < l1.date
    )
    group by l1.date
) as l3
on l0.date = l3.date

