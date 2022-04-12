create table type(
id serial primary key,
	name text
);

create table product(
id serial primary key,
	name text,
	type_id int references type(id),
	expired_date date,
	price int
);

insert into type(name) values ('СЫР'), ('МОЛОКО'), ('НАПИТОК'), ('ОВОЩИ/ФРУКТЫ');
insert into product(name, type_id, expired_date, price) values
('Сыр плавленный', 1, '2022-03-01', 120),
('Сыр пармезан', 1, '2022-09-01', 320),
('Миринда ', 3, '2024-03-01', 155),
('Вода', 3, '2022-10-01', 25),
('Кефир', 2, '2022-02-01', 65),
('Сметана', 2, '2022-02-01', 63),
('Йогурт', 2, '2022-05-01', 60),
('Огурец', 4, '2022-02-10', 55),
('Яблоко', 4, '2022-02-17', 53),
('Чай',3, '2029-02-01', 50),
('Сыр Сулугуни', 1, '2022-07-01', 45),
('Ряженка', 2, '2022-05-01', 40),
('Капуста', 4, '2022-03-02', 106),
('Банан', 4, '2022-03-27', 844),
('Снежок', 2, '2022-06-01', 306),
('Мороженое', 2, '2023-02-01', 3),
('Жирное молоко', 2, '2022-05-01', 30),
('Жирный творог', 2, '2022-02-01', 100),
('Пепси', 3, '2026-02-01', 1000),
('Кофе', 3, '2026-02-01', 2000),
('Водка', 3, '2029-02-01', 55);

select p.name
from product as p join type as t
on p.type_id = t.id
where t.name like '%СЫР%';

select p.name from product as p where p.name like '%Мороженое%';

select p.name, p.expired_date
from product as p
where p.expired_date < current_date;

select max(p.price) , p.name from product as p order by p.price desc limit 1;

select t.name as имя_типа, count(*) as количество
from type as t join product as p
on p.type_id = t.id
group by t.name;

select t.name, count(*)
from type as t join product as p
on p.type_id = t.id
where t.name like '%СЫР%' or t.name like '%МОЛОКО%'
group by t.name;

select t.name, count(*)
from type as t join product as p
on p.type_id = t.id
group by t.name
having count(*) < 10;

select p.name, p.type_id
from product as p;