use nowcoder;
CREATE TABLE actor
(
    actor_id smallint(5) NOT NULL PRIMARY KEY,
    first_name varchar(45) NOT NULL,
    last_name varchar(45) NOT NULL,
    last_update timestamp not null default now()
);

insert into actor values (1, 'PENELOPE', 'GUINESS', now());
insert into actor values (2, 'NICK', 'WAHLBERG', now());