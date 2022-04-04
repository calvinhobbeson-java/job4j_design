create table wallet (
	id serial primary key,
	name text,
	number int
);

create table users (
	id serial primary key,
	name text,
	wallet_id int references wallet(id) unique
);

insert into wallet (name, number) values ('advCash', 12345);
insert into wallet (name, number) values ('pgwPingwi', 54321);
insert into wallet (name, number) values ('Jeton', 33456);

insert into users (name, wallet_id) values ('Oleg', 1);
insert into users (name, wallet_id) values ('Grigory', 2);
insert into users (name, wallet_id) values ('Vasily', 3);
insert into users (name) values ('Nikolaj');

select u.name, w.name, w.number 
from users as u join wallet as w 
on u.wallet_id = w.id;

select u.name as Имя, w.name as Название_кошелька, w.number as Номер_кошелька 
from users as u join wallet as w
on u.wallet_id = w.id where w.name like 'adv%' and u.wallet_id = w.id;

select u.name, w.name, w.number 
from users as u join wallet as w 
on u.wallet_id = w.id where u.name like 'Ol%' or u.name like 'Vas%';