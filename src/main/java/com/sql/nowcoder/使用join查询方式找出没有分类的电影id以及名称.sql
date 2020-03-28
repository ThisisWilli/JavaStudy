# 使用join查询方式找出没有分类的电影id以及名称
use nowcoder;
select film.film_id, film.title
from film
left join film_category
on film.film_id = film_category.film_id
where film_category.category_id is null