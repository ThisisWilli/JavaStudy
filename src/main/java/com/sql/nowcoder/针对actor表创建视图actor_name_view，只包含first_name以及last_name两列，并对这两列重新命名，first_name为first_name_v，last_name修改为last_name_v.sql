# 针对actor表创建视图actor_name_view，只包含first_name以及last_name两列，并对这两列重新命名，first_name为first_name_v，last_name修改为last_name_v：
use nowcoder;
create view actor_name_view(first_name_v, last_name_v) as
select first_name, last_name from actor