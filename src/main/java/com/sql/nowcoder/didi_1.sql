use nowcoder;
create table user_payment(
    `id` varchar(50),
    amount int,
    order_type varchar(50),
    payment_chnl varchar(50)
)

select
       payment_chnl,
       ifnull(kuaiche_amt, 0) as kuaiche_amt,
       ifnull(shunfengche_amt, 0) as shunfengche_amt,
       ifnull(zhuanche_amt, 0) as zhuanche_amt
from
(
    select payment_chnl,
        sum(case when order_type = 'kuaiche' then amount end ) as 'kuaiche_amt',
        sum(case when order_type = 'shunfengche' then amount end ) as 'shunfengche_amt',
        sum(case when order_type = 'zhuanche' then amount end ) as 'zhuanche_amt'
    from t_user_payment
    group by payment_chnl
    order by payment_chnl asc
    )as a