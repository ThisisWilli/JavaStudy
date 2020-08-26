use nowcoder;
create table login(
    id int,
    user_id int,
    client_id int,
    date date
);

insert into login values
(1, 2, 1, '2020-10-12'),
(2, 3, 2, '2020-10-12'),
(3, 2, 2, '2020-10-13'),
(4, 3, 2, '2020-10-13');

select max(login.date) as d
from login
group by login.user_id;