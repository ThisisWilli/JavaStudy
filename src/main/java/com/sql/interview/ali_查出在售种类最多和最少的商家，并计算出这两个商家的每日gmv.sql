use interview;
drop table dwd_ae_trd_all_df;
create table dwd_ae_trd_all_df(
    store varchar(50),
    order_id varchar(50),
    amount int,
    order_time timestamp
);

insert into dwd_ae_trd_all_df values
('A1', 'A-43213355', 20, '2020-07-01 12:30:14'),
('A2', 'A-43213355', 15, '2020-07-02 10:10:31'),
('A2', 'A-413131325', 20, '2020-07-01 12:30:14');
insert into dwd_ae_trd_all_df values ('A3', 'A-413131325', 100, '2020-07-01 12:30:14');
create table dim_ae_itm(
    store varchar(40),
    name varchar(50),
    itm_cate varchar(50)
)character set = utf8;
insert into dim_ae_itm values
('A1', 'air01', '运动鞋'),
('A1', 'air02', '休闲鞋'),
('A2', 'book01', '小说书'),
('A2', 'book02', '财经类');
insert into dim_ae_itm values('A3', 'book03', '侦探类');
insert into dim_ae_itm values('A3', 'book03', '侦探类');

# 已知有订单销量表 dwd_ae_trd_all_df,
# 商品表 dim_ae_itm，请仅用一条SQL查询出在售种类（在售种类=商品类型去重计数）最多和最少（如果最多或最少有多个，随机取1个）的商家，
# 并计算出这两个商家的每日GMV（GMV=订单金额求和）。如果不行，可给出多条SQL版本。
# 订单销量表 dwd_ae_trd_all_df

select d0.store,  min(d0.num) as max, max(d0.num) as min
from
(
    select dim_ae_itm.store, count(distinct dim_ae_itm.itm_cate) as num
    from dim_ae_itm
    group by dim_ae_itm.store
) as d0
group by d0.num;

select sum(dwd_ae_trd_all_df.amount)
from dwd_ae_trd_all_df
where dwd_ae_trd_all_df.store in (
    select d00.store
    from
    (select d0.store,  min(d0.num) as max, max(d0.num) as min
    from
        (
            select dim_ae_itm.store, count(distinct dim_ae_itm.itm_cate) as num
            from dim_ae_itm
            group by dim_ae_itm.store
        ) as d0
    group by d0.num) as d00
    );



# 1. 查出每个商家的销售种类
select dim_ae_itm.store, count(distinct dim_ae_itm.itm_cate) as num
from dim_ae_itm
group by dim_ae_itm.store