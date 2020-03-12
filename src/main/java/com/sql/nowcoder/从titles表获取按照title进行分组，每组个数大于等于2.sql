# 从titles表获取按照title进行分组，每组个数大于等于2，给出title以及对应的数目t。
# 注意对于重复的emp_no进行忽略。
use LeetCode;
select *
from Scores;

select id, Score
from Scores
group by Score;