use nowcoder;
# 牛客每天有很多人登录，
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


# 请你统计一下牛客每个日期新用户的次日留存率。 第二天这些新用户有多少登录了 / 第一天产生的所有新用户
# 1. 计算出今天的所有新用户
select l1.date, l1.user_id
from login as l1
where l1.user_id not in(
    select distinct l2.user_id
    from login as l2
    where l2.date < l1.date
);

# 2. 查看今天有多少个新用户
select l1.date, count(l1.user_id)
from login as l1
where l1.user_id not in(
    select distinct l2.user_id
    from login as l2
    where l2.date < l1.date
)group by l1.date;

# 补零;

select ll0.date, (case when ll1.new is null then 0 else ll1.new end) as daily_new
from
(
    select login.date
    from login
    group by login.date
) as ll0
left join
(
    select l1.date, count(l1.user_id) as new
    from login as l1
    where l1.user_id not in(
        select distinct l2.user_id
        from login as l2
        where l2.date < l1.date
    )group by l1.date
) as ll1
on ll0.date = ll1.date;



# 2. 查看第二天有多少前一天的新用户登陆了系统
select date_sub(l0.date, interval 1 day) as date, count(l0.user_id)
from login as l0
where l0.user_id in (
         # 得到l0前一天的新用户
          select l1.user_id
          from login as l1
          where l1.user_id not in(
              select distinct l2.user_id
              from login as l2
              where l2.date < l1.date
          ) and datediff(l0.date, l1.date) = 1
            and l0.user_id = l1.user_id
)group by l0.date;

# 补零
select ll0.date, (case when ll1.duration is null then 0 else ll1.duration end) as daily_new
from
    (
        select login.date
        from login
        group by login.date
    ) as ll0
        left join
    (
        select date_sub(l0.date, interval 1 day) as date, count(l0.user_id) as duration
        from login as l0
        where l0.user_id in (
            # 得到l0前一天的新用户
            select l1.user_id
            from login as l1
            where l1.user_id not in(
                select distinct l2.user_id
                from login as l2
                where l2.date < l1.date
            ) and datediff(l0.date, l1.date) = 1
              and l0.user_id = l1.user_id
        )group by l0.date
    ) as ll1
    on ll0.date = ll1.date;


select t1.date, (case when t2.duration / t1.daily_new is null then 0 else round(t2.duration / t1.daily_new, 3) end) as p
from
(
    select ll0.date, (case when ll1.new is null then 0 else ll1.new end) as daily_new
    from
        (
            select login.date
            from login
            group by login.date
        ) as ll0
            left join
        (
            select l1.date, count(l1.user_id) as new
            from login as l1
            where l1.user_id not in(
                select distinct l2.user_id
                from login as l2
                where l2.date < l1.date
            )group by l1.date
        ) as ll1
        on ll0.date = ll1.date
    ) as t1
inner join
(
    select ll0.date, (case when ll1.duration is null then 0 else ll1.duration end) as duration
    from
        (
            select login.date
            from login
            group by login.date
        ) as ll0
            left join
        (
            select date_sub(l0.date, interval 1 day) as date, count(l0.user_id) as duration
            from login as l0
            where l0.user_id in (
                # 得到l0前一天的新用户
                select l1.user_id
                from login as l1
                where l1.user_id not in(
                    select distinct l2.user_id
                    from login as l2
                    where l2.date < l1.date
                ) and datediff(l0.date, l1.date) = 1
                  and l0.user_id = l1.user_id
            )group by l0.date
        ) as ll1
        on ll0.date = ll1.date
    ) as t2
on t1.date = t2.date
order by t1.date;
