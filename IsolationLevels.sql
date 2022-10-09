create table goods (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

insert into goods (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into goods (name, producer, count, price) VALUES ('product_2', 'producer_2', 15, 32);
insert into goods (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);

set session transaction isolation level read uncommitted;