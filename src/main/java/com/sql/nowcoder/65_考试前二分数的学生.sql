use nowcoder;
create table grade(
    id int,
    language_id int,
    score int
);
insert into grade values
(1, 1, 12000),
(2, 1, 13000),
(3, 2, 11000),
(4, 2, 10000),
(5, 3, 11000),
(6, 1, 11000),
(7, 2, 11000);

create table language(
    id int,
    name varchar(50)
);

insert into language values
(1, 'C++'),
(2, 'JAVA'),
(3, 'Python');


select g1.id, l.name, g1.score
from grade g1 join language l on g1.language_id=l.id
where
(
          select count(distinct g2.score)
          from grade g2
          where g2.score>=g1.score and g1.language_id=g2.language_id
)
          <=2
order by l.name,g1.score desc ,g1.id;

