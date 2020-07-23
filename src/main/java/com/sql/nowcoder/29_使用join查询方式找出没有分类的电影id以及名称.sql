# 使用join查询方式找出没有分类的电影id以及名称
use nowcoder;

select film.film_id, film.title
from film
where film.film_id not in
(
    select film_category.film_id
    from film_category
    );

select film.film_id, film.title
from film
left join film_category
on film_category.film_id  = film.film_id
where film_category.category_id is null;