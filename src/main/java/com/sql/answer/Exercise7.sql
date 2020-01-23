use MySqlAnswer;
select * from Student where S not in (
    select SC.S from SC
    group by SC.S
    having count(C) = (select count(C) from Course));