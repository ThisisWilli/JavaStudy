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


