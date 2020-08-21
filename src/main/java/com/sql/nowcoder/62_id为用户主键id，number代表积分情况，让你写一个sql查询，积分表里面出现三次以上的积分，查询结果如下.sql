use nowcoder;
create table if not exists grade(
    id varchar(50),
    number INT
);
insert grade values (1, 111);
insert grade values (2, 333);
insert grade values (3, 111);
insert grade values (4, 111);
insert grade values (5, 333);

select number
from grade
group by number
having count(number) >= 3
;

