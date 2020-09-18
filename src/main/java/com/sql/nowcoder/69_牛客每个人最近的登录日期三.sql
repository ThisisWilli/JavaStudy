use nowcoder;
# 第1行表示id为2的用户在2020-10-12使用了客户端id为1的设备第一次新登录了牛客网
# 。。。
# 第4行表示id为3的用户在2020-10-14使用了客户端id为2的设备登录了牛客网
#
#
# 请你写出一个sql语句查询新登录用户次日成功的留存率，即第1天登陆之后，第2天再次登陆的概率,保存小数点后面3位(3位之后的四舍五入)，上面的例子查询结果如下:
# 查询结果表明:
# id为2的用户在2020-10-12第一次新登录了，在2020-10-13又登录了，算是成功的留存
# id为3的用户在2020-10-12第一次新登录了，在2020-10-13没登录了，算是失败的留存
# 固次日成功的留存率为 1/2=0.5
# (sqlite里查找某一天的后一天的用法是:date(yyyy-mm-dd, '+1 day')，四舍五入的函数为round，sqlite 1/2得到的不是0.5，得到的是0，只有1*1.0/2才会得到0.5)

select *
from login;

update
login
set login.date = '2020-10-14'
where login.id = 4;

select
    round(count(distinct user_id)*1.0/(select count(distinct user_id) from login) ,3)
from login
where (user_id,date)
          in (select user_id,date(min(date),'+1 day') from login group by user_id);

use nowcoder;
drop table login;
create table login(
                      id int,
                      user_id int,
                      client_id int,
                      date date
);

insert into login values
(1, 2, 1, '2020-10-12'),
(2, 3, 2, '2020-10-12'),
(3, 1, 2, '2020-10-12'),
(4, 2, 2, '2020-10-13'),
(5, 4, 1, '2020-10-13'),
(6, 1, 2, '2020-10-13');

# 1. 找出当天新登录的用户
select l1.date, l1.user_id
from login l1
where l1.user_id not in
(
    select l2.user_id
    from login l2
    where l1.date > l2.date
);

# 2. 将明天新登录的用户是否包含当天新登录的用户，占了多少

# 2. 计算明天有哪几个新用户登录了
select ll1.date, ll2.user_id
from login as ll1
inner join
    (
    select l1.date, l1.user_id
    from login l1
    where l1.user_id not in
          (
              select l2.user_id
              from login l2
              where l1.date > l2.date
          )
    ) as ll2
on ll1.date = ll2.date + 1 and ll1.user_id = ll2.user_id;

# 3. 计算最终结果

select l1.date, count(l1.user_id) as new_user_per_day
from login l1
where l1.user_id not in
      (
          select l2.user_id
          from login l2
          where l1.date > l2.date
      )
group by l1.date;

select ll2.date, count(ll2.user_id) as still_login_per_day
from login as ll1
         inner join
     (
         select l1.date, l1.user_id
         from login l1
         where l1.user_id not in
               (
                   select l2.user_id
                   from login l2
                   where l1.date > l2.date
               )
     ) as ll2
     on ll1.date = ll2.date + 1 and ll1.user_id = ll2.user_id
group by ll2.date;

select  round(1.0 * ll2.still_login_per_day / ll1.new_user_per_day, 3) as p
from
(
    select l1.date, count(l1.user_id) as new_user_per_day
    from login l1
    where l1.user_id not in
          (
              select l2.user_id
              from login l2
              where l1.date > l2.date
          )
    group by l1.date
    ) as ll1
inner join
(
    select ll2.date, count(ll2.user_id) as still_login_per_day
    from login as ll1
             inner join
         (
             select l1.date, l1.user_id
             from login l1
             where l1.user_id not in
                   (
                       select l2.user_id
                       from login l2
                       where l1.date > l2.date
                   )
         ) as ll2
#          on ll1.date = date(ll2.date, '+1 day') and ll1.user_id = ll2.user_id
         on ll1.date = ll2.date + 1 and ll1.user_id = ll2.user_id
    group by ll2.date
    ) as ll2
on ll1.date = ll2.date