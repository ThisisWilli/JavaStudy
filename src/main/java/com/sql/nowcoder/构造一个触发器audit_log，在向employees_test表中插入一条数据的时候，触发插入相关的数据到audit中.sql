use nowcoder;
create trigger audit_log after insert on employees_test
    begin
        insert into audit values (NEW.ID, NEW.NAME)
    end;