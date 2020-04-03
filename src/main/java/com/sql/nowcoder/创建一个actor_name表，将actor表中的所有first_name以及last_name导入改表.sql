use nowcoder;
CREATE TABLE actor_name
(
    first_name varchar(45) NOT NULL,
    last_name varchar(45) NOT NULL
);
insert into actor_name select first_name, last_name from actor