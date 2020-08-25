use nowcoder;
drop table email, user;
CREATE TABLE `email` (
                         `id` int(4) NOT NULL,
                         `send_id` int(4) NOT NULL,
                         `receive_id` int(4) NOT NULL,
                         `type` varchar(32) NOT NULL,
                         `date` date NOT NULL,
                         PRIMARY KEY (`id`));

CREATE TABLE `user` (
                        `id` int(4) NOT NULL,
                        `is_blacklist` int(4) NOT NULL,
                        PRIMARY KEY (`id`));

INSERT INTO email VALUES
(1,3,2,'completed','2020-01-11'),
(2,1,3,'completed','2020-01-11'),
(3,1,4,'no_completed','2020-01-11'),
(4,3,1,'no_completed','2020-01-12'),
(5,3,4,'completed','2020-01-12'),
(6,4,1,'completed','2020-01-12'),
(7,4,3,'completed','2020-01-12'),
(8,4,2,'completed','2020-01-12'),
(9,4,1,'completed','2020-01-12'),
(10,3,2,'completed','2020-01-13'),
(11,4,1,'no_completed','2020-01-13'),
(12,4,1,'no_completed','2020-01-13'),
(13,1,3,'no_completed','2020-01-13');

INSERT INTO user VALUES
(1,0),
(2,1),
(3,0),
(4,0);


# select e1.date,
#        (case e2.completed when e2.completed is null then 1 else round((e1.total - e2.completed) * 1.0 / e1.total, 3) end ) as p
select e1.date,
       (case when e2.completed is null then 1 else round((e1.total - e2.completed) * 1.0 / e1.total, 3) end ) as p
#         if(e2.completed is null, 1, round((e1.total - e2.completed) * 1.0 / e1.total, 3)) as p
from
(
    select email.date, count(email.type) as total
    from email
    where email.send_id not in(select user.id from user where user.is_blacklist = 1)
      and email.receive_id not in(select user.id from user where user.is_blacklist = 1)
    group by email.date
) as e1
left join
(
    select email.date, count(email.type) as completed
    from email
    where email.send_id not in(select user.id from user where user.is_blacklist = 1)
      and email.receive_id not in(select user.id from user where user.is_blacklist = 1)
      and email.type = 'completed'
    group by email.date
) as e2
on e1.date = e2.date
