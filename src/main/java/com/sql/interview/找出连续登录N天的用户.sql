use interview;
CREATE TABLE user_login
(UID BIGINT,
 LOADTIME DATETIME);
INSERT INTO user_login
    VALUES
(201,'2017/1/1'),
(201,'2017/1/2'),
(202,'2017/1/2'),
(202,'2017/1/3'),
(203,'2017/1/3'),
(201,'2017/1/4'),
(202,'2017/1/4'),
(201,'2017/1/5'),
(202,'2017/1/5'),
(201,'2017/1/6'),
(203,'2017/1/6'),
(203,'2017/1/7');

select t1.UID, max(t1.con_day) as max_continue_day
from (
         select UID,
                LOADTIME,
                case
                    when UID = @last_uid and date_add(@last_load_time, interval 1 day) = LOADTIME
                        then @continue_day := @continue_day + 1
                    else @continue_day := 1
                    end as con_day,
                @last_uid := UID,
                @last_load_time := LOADTIME
         from (
                  select UID, LOADTIME
                  from user_login
                  order by UID, LOADTIME
              ) as u1, (select @last_uid := 0, @last_load_time := 0, @continue_day := 0) as l2
     ) as t1
group by t1.UID
