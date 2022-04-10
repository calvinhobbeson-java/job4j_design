create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Iphone', 56000), ('Samsung', 20000), ('Macbook', 230000);
insert into people(name) values ('Oleg'), ('Necromancer'), ('Yellow');
insert into devices_people(device_id, people_id) values (1, 1), (2, 1);
insert into devices_people(device_id, people_id) values (1, 2), (3, 2);
insert into devices_people(device_id, people_id) values (2, 3), (3, 3);

select avg(price) from devices;

select p.name, avg(d.price)
from devices_people as dp
join devices d on dp.device_id = d.id
join people p on dp.people_id = p.id
group by p.name;

select p.name, avg(d.price)
from devices_people as dp
join devices d on dp.device_id = d.id
join people p on dp.people_id = p.id
group by p.name
having avg(d.price) > 5000;