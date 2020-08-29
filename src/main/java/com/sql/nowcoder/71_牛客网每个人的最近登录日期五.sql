use nowcoder;
# 牛客每天有很多人登录，请你统计一下牛客每个日期新用户的次日留存率。
truncate table login;
insert into login values
(1, 2, 1, '2020-10-12'),
(2, 3, 2, '2020-10-12'),
(3, 1, 2, '2020-10-12'),
(4, 2, 2, '2020-10-13'),
(5, 1, 2, '2020-10-13'),
(6, 3, 1, '2020-10-14'),
(7, 4, 1, '2020-10-14'),
(8, 4, 1, '2020-10-15');

# 求解每个日期的新用户求法为
select login.date, ifnull(n1.new_num,0)
from login
left join
 (
     select l1.date,count(distinct l1.user_id) as new_num
     from login l1
     where l1.date =
        (select min(date) from login where user_id=l1.user_id)
     group by l1.date) n1
on login.date = n1.date
group by login.date;

select l1.date,count(distinct l1.user_id) as new_num
from login l1
where l1.date =
      (select min(date) from login where user_id=l1.user_id)
group by l1.date;



