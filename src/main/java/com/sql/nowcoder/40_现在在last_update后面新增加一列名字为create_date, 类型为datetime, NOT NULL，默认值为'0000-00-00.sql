# 现在在last_update后面新增加一列名字为create_date, 类型为datetime, NOT NULL，默认值为'0000-00-00
use nowcoder;
alter table actor add column create_date datetime not null default '0000-00-00 00:00:00'