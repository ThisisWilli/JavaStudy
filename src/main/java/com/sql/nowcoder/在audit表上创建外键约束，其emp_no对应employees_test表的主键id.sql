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
                      create_date datetime NOT NULL
);

alter table audit
add foreign key (EMP_no) references employees_test(id)