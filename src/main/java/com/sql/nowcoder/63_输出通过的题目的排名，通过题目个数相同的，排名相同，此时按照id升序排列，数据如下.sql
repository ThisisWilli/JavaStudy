use nowcoder;
create table if not exists passing_number(
                                    id varchar(50),
                                    number INT
);
insert passing_number values (1, 4);
insert passing_number values (2, 3);
insert passing_number values (3, 3);
insert passing_number values (4, 2);
insert passing_number values (5, 5);
insert passing_number values (6, 4);


select g1.id, g1.number, count(distinct g2.number) as `rank`
from passing_number g1, passing_number g2
where g1.number <= g2.number
group by g1.id, g1.number
order by `rank`