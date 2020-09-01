use interview;
create table dws_ae_slr_1d(
    store varchar(50),
    cate varchar(50),  # 行业
    sell_cnt int,
    gmv int
);
insert into dws_ae_slr_1d values
('A1', 'female', 20, 300),
('A2', 'female', 10, 500),
('B1', 'male', 15, 400),
('C1', 'shoes', 40, 850);
# 请仅用一条SQL查询出每个行业的销量最高的Top 20商家，并给出按销售额从高到低给出综合排序（需展示出序号）。如果不行，可给出多条SQL版本。
select d1.store, d1.cate, count(d2.gmv) as rank_num
from dws_ae_slr_1d d1
inner join dws_ae_slr_1d d2
on d1.cate = d2.cate and d1.gmv <= d2.gmv
group by d1.store, d1.cate
order by d1.cate, rank_num;

# 1. 第一种方法：
select *
from dws_ae_slr_1d as d1
where
(
   select count(*)
   from dws_ae_slr_1d as d2
   where d1.cate = d2.cate and d2.gmv <= d1.gmv
) <= 1;


(select * from dws_ae_slr_1d where dws_ae_slr_1d.cate = 'female' order by dws_ae_slr_1d.gmv)
union all
(select * from dws_ae_slr_1d where dws_ae_slr_1d.cate = 'male' order by dws_ae_slr_1d.gmv)
union all
(select * from dws_ae_slr_1d where dws_ae_slr_1d.cate = 'shoes' order by dws_ae_slr_1d.gmv)

