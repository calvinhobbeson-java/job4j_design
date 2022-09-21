create or replace procedure delete_data(id_item  integer)
language 'plpgsql'
as $$
    BEGIN
    delete from products where id = id_item;
    END
$$;

call delete_data(1);

select * from products;

create or replace function f_delete_data(id_item  integer)
returns void
language 'plpgsql'
as
$$
    begin
        delete from products where id = id_item;
    end;
$$;

select f_delete_data(2);

select * from products;