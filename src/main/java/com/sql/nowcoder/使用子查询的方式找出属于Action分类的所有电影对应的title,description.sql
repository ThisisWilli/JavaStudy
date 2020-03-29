# 使用子查询的方式找出属于Action分类的所有电影对应的title,description
use nowcoder;

select film.title, film.description
from film,film_category
where film.film_id = film_category.film_id and film_category.category_id =
    (
    select category.category_id
    from category
    where category.name = 'Action'
    )