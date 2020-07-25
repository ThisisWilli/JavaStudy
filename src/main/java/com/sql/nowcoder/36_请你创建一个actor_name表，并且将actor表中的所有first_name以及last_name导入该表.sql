# 请你创建一个actor_name表，并且将actor表中的所有first_name以及last_name导入该表.
CREATE TABLE actor_name
(
    first_name varchar(45) NOT NULL,
    last_name varchar(45) NOT NULL
);
insert into actor_name select first_name, last_name from actor