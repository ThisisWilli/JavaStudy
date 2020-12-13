# 查询各科前三名的记录
use MysqlExercise;
# 若为非相关子查询，先执行内部查询，内部查询作为外部查询的筛选条件
# 属于相关子查询，先执行外部查询，再执行内部查询，先from再where再distinct再orderby
select * from scores as score1
where 3 >=
    # 括号中相当于是筛选条件
    (
        # 先算出所有的不重复的分数个数
        select
               # 比如s1 = s2 = [4, 5, 6, 7]
               # s1 = 7, s2 = [7] count(s2) = 1
               # s1 = 6, s2 = [6, 7] count(s2) = 2
               # s1 = 5, s2 = [5, 6, 7] count(s3) = 3
               # s1 = 4, s2 = [4, 5, 6, 7] count(s4) = 4
               # s1 <= 3, 所以取出5， 6， 7三种情况，相当于选出了s1前三高的分数
               count(distinct score2.score) from scores as score2
        where score1.course_id = score2.course_id and score2.score >= score1.score
        )
order by score1.course_id,score1.score desc ;

# select *
# from scores as score1
# where 3 >= (
#           select count(distinct score2.score)
#           from scores as score2
#           where score1.course_id = score2.course_id and score2.score >= score1.score
#           )
# order by score1.course_id
