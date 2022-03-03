create table steam(
	id serial primary key,
	login varchar(255)
);

create table person(
	id serial primary key,
	name varchar(255),
	steam_id int references steam(id) unique
);

insert into steam(login) values ('nguen@gmail.com');
insert into person(name, steam_id) values ('Ivan', 1);