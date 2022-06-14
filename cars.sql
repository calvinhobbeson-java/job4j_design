create table kuzov(
id serial primary key,
name varchar(255)
);

create table dvigatel(
id serial primary key,
name varchar(255)
);
create table peredacha(
id serial primary key,
name varchar(255)
);

create table cars(
id serial primary key,
name varchar(255),
kuzov_id int references kuzov(id),
dvigatel_id int references dvigatel(id),
peredacha_id int references peredacha(id)
);


insert into kuzov(name) values ('BMW_kuzov');
insert into kuzov(name) values ('AUDI_kuzov');
insert into kuzov(name) values ('VOLVO_kuzov');

insert into dvigatel(name) values ('AUDI_dvigatel');
insert into dvigatel(name) values ('VOLVO_dvigatel');
insert into dvigatel(name) values ('UAZ_dvigatel');

insert into peredacha(name) values ('BMW_peredacha');
insert into peredacha(name) values ('VOLVO_peredacha');
insert into peredacha(name) values ('UAZ_peredacha');

insert into cars(name, kuzov_id, dvigatel_id, peredacha_id) values ('BMW', 1, null, 1);
insert into cars(name, kuzov_id, dvigatel_id, peredacha_id) values ('Audi', 2, 1, null);
insert into cars(name, kuzov_id, dvigatel_id, peredacha_id) values ('Volvo', 3, 2, 2);

select c.name as name, k.name as kuzov, d.name as dvigatel, p.name as peredacha
from cars c left join kuzov k on c.kuzov_id = k.id
left join dvigatel d on c.dvigatel_id = d.id
left join peredacha p on c.peredacha_id = p.id;

select d.name as dvigatel
from cars c right join dvigatel d on c.dvigatel_id = d.id
where c.name is null;

select p.name as peredacha
from cars c right join peredacha p on c.peredacha_id = p.id
where c.name is null;

