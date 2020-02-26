use LeetCode;
Create table If Not Exists seat(id int, student varchar(255));
Truncate table seat;
insert into seat (id, student) values ('1', 'Abbot');
insert into seat (id, student) values ('2', 'Doris');
insert into seat (id, student) values ('3', 'Emerson');
insert into seat (id, student) values ('4', 'Green');
insert into seat (id, student) values ('5', 'Jeames');

select *
from seat;

select if(mod (id, 2) = 1, if(id != (select count(*) from seat), id + 1, id), id - 1) as id, student
from seat
order by id;

