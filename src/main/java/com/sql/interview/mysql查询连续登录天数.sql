create database interview;
CREATE TABLE `tmp_test_lianxu_3` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT,
                                     `uid` int(11) DEFAULT NULL,
                                     `sts` datetime DEFAULT NULL COMMENT '登录时间',
                                     `ets` datetime DEFAULT NULL COMMENT '离线时间',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
INSERT INTO `tmp_test_lianxu_3` VALUES (1, 1, '2014-1-1 21:00:00', '2014-1-2 07:00:00');
INSERT INTO `tmp_test_lianxu_3` VALUES (2, 1, '2014-1-2 15:37:57', '2014-1-2 21:00:00');
INSERT INTO `tmp_test_lianxu_3` VALUES (3, 2, '2014-1-1 09:00:00', '2014-1-1 15:00:00');
INSERT INTO `tmp_test_lianxu_3` VALUES (4, 2, '2014-1-2 09:00:00', '2014-2-1 16:00:00');
INSERT INTO `tmp_test_lianxu_3` VALUES (5, 1, '2014-1-4 10:00:00', '2014-1-4 18:00:00');
INSERT INTO `tmp_test_lianxu_3` VALUES (6, 1, '2014-1-5 12:00:00', '2014-1-5 13:00:00');
INSERT INTO `tmp_test_lianxu_3` VALUES (7, 2, '2014-1-10 00:00:00', '2014-1-10 06:00:00');
INSERT INTO `tmp_test_lianxu_3` VALUES (8, 2, '2014-1-11 13:00:00', '2014-1-11 18:00:00');
INSERT INTO `tmp_test_lianxu_3` VALUES (10, 2, '2014-1-12 12:00:00', '2014-1-12 18:00:00');
INSERT INTO `tmp_test_lianxu_3` VALUES (11, 1, '2014-1-8 06:00:00', '2014-1-8 16:00:00');
INSERT INTO `tmp_test_lianxu_3` VALUES (12, 2, '2014-1-11 21:00:00', '2014-1-12 06:00:00');

SELECT uid, max(days) lianxu_days, min(login_day) start_date,max(login_day) end_date
FROM (SELECT uid,
             @cont_day :=
                     (CASE
                          WHEN (@last_uid = uid AND DATEDIFF(login_dt, @last_dt)=1) THEN
                              (@cont_day + 1)
                          WHEN (@last_uid = uid AND DATEDIFF(login_dt, @last_dt)<1) THEN
                              (@cont_day + 0)
                          ELSE
                              1
                         END) AS days,
             (@cont_ix := (@cont_ix + IF(@cont_day = 1, 1, 0))) AS cont_ix,
             @last_uid := uid,
             @last_dt := login_dt login_day
      FROM (SELECT uid, DATE(sts) AS login_dt
            FROM tmp_test_lianxu_3
            ORDER BY uid, sts) AS t,
           (SELECT @last_uid := '',
                   @last_dt  := '',
                   @cont_ix  := 0,
                   @cont_day := 0) AS t1) AS t2
GROUP BY uid, cont_ix;

# ================================================
# 1. 创建四个局部变量
(select @last_uid := '', @last_dt := '', @cont_ix := 0, @cont_day := 0) as t1;
# 2. 将原来的表按照user id进行进行第一位排序，再按照每个用户的登录时间进行排序
select uid, DATE(sts) as login_dt
from tmp_test_lianxu_3
order by tmp_test_lianxu_3.uid, tmp_test_lianxu_3.sts;

# 3. 两张表进行join

#@cont_day := if((@last_uid = uid and DATEDIFF(login_dt, @last_dt) = 1), (@cont_day + 1), 1) as continuous_login,
# 如果当前
# (@cont_ix := (@cont_ix + if(@cont_day = 1, 1, 0))) as cont_ix,
#        @last_uid := uid,
#        @last_dt := login_dt

select uid,
       # 如果当前这条数据与之前的数据的用户id相同，并且这条数据的登录日期与上次登录日期的差值为1，那么@cont_day这条数据 + 1
       @cont_day := if((@last_uid = uid and DATEDIFF(login_dt, @last_dt) = 1), @cont_day + 1, 1) as continuous_login,
       @cont_ix := (@cont_ix + if(@cont_day = 1, 1, 0)) as cont_ix,
       @last_uid := uid,
       @last_dt := login_dt

from
(
    select uid, DATE(sts) as login_dt
    from tmp_test_lianxu_3
    order by tmp_test_lianxu_3.uid, tmp_test_lianxu_3.sts
) as t1, (select @last_uid := '', @last_dt := '', @cont_ix := 0, @cont_day := 0) as t2;

# 每个人不同连续登录天数，出现的次数
select main.uid, if(continuous_login = 1, continuous_login, null) as res
from
(
    select uid,
           # 如果当前这条数据与之前的数据的用户id相同，并且这条数据的登录日期与上次登录日期的差值为1，那么@cont_day这条数据 + 1
           @cont_day := if((@last_uid = uid and DATEDIFF(login_dt, @last_dt) = 1), @cont_day + 1, 1) as continuous_login,
           @cont_ix := (@cont_ix + if(@cont_day = 1, 1, 0)) as cont_ix,
           @last_uid := uid,
           @last_dt := login_dt

    from
        (
            select uid, DATE(sts) as login_dt
            from tmp_test_lianxu_3
            order by tmp_test_lianxu_3.uid, tmp_test_lianxu_3.sts
        ) as t1, (select @last_uid := '', @last_dt := '', @cont_ix := 0, @cont_day := 0) as t2
    ) as main
group by uid, continuous_login







