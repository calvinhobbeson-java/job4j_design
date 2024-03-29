create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_1', 3, 50);

create or replace function additionalTax()
    returns trigger as
$$
    BEGIN
        NEW.price = NEW.price + NEW.price * 0.2;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger additional_tax_trigger
    before insert
    on products
    for each row
    execute procedure additionalTax();

insert into products (name, producer, count, price) VALUES ('product_4', 'producer_1', 3, 50);

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function add_info()
    returns trigger as
$$
    BEGIN
        insert into history_of_price (name, price, date)
		values (NEW.name, NEW.price, now());
		RETURN NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger add_into_table_trigger
    after insert
    on products
    for each row
    execute procedure add_info();

select * from history_of_price

