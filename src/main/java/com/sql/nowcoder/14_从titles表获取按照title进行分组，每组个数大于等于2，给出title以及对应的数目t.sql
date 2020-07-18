# 从titles表获取按照title进行分组，每组个数大于等于2，给出title以及对应的数目t。
# 注意对于重复的emp_no进行忽略(即emp_no重复的title不计算，title对应的数目t不增加)。

use nowcoder;
select title, count(distinct emp_no) as n
from titles
group by title
having n >= 2;

# group by titles.title;