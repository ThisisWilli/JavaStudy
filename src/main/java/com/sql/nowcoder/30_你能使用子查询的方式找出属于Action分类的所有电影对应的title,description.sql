# 你能使用子查询的方式找出属于Action分类的所有电影对应的title,description吗
use nowcoder;
select film_category.film_id
from film_category, category
where film_category.category_id = category.category_id and category.name = 'action';

select film.title, film.description
from film
where film.film_id in
(
    select film_category.film_id
    from film_category
    where category_id in
    (
        select category.category_id
        from category
        where name like 'action'
        )
    );

select film_category.film_id
from film_category, category
where film_category.category_id = category.category_id and category.name = 'Action'