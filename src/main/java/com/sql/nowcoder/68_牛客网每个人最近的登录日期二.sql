use nowcoder;
drop table user;
create table user(
    id int,
    name varchar(50)

);

insert into user values
(1, 'tm'),
(2, 'fh'),
(3, 'wangchao');

create table client(
    id int,
    name varchar(50)
);

insert into client values
(1, 'pc'),
(2, 'ios'),
(3, 'android'),
(4, 'h5');




select u.name as u_n, c.name as c_n, max(login.date) as d
from login
inner join user u on login.user_id = u.id
inner join client c on login.client_id = c.id
group by login.user_id/*, u.name*/
order by u.name