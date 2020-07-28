use nowcoder;
CREATE TABLE employees_test(
                               ID INT PRIMARY KEY NOT NULL,
                               NAME TEXT NOT NULL,
                               AGE INT NOT NULL,
                               ADDRESS CHAR(50),
                               SALARY REAL
);

CREATE TABLE audit(
                      EMP_no INT NOT NULL,
                      NAME TEXT NOT NULL
);

create trigger audit_log after insert on employees_test
    begin
        insert into audit values (NEW.ID, NEW.NAME);
    end;