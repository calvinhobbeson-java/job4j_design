 create table people(
     id serial primary key,
     name varchar(255)
 );
 
 create table restraunts(
     id serial primary key,
     name varchar(255)
 );
 
 create table people_restraunts(
     id serial primary key,
     people_id int references people(id),
     restraunts_id int references restraunts(id)
 );
insert into people(name) values ('Olig');
insert into people(name) values ('Igor');
insert into people(name) values ('Roman');

insert into restraunts(name) values ('Tokio city');
insert into restraunts(name) values ('Yarumen');
insert into restraunts(name) values ('Phali hinkali');

insert into people_restraunts(people_id, restraunts_id) values (1, 2);
insert into people_restraunts(people_id, restraunts_id) values (3, 2);
insert into people_restraunts(people_id, restraunts_id) values (1, 3);
insert into people_restraunts(people_id, restraunts_id) values (2, 3);
insert into people_restraunts(people_id, restraunts_id) values (2, 2);
insert into people_restraunts(people_id, restraunts_id) values (3, 1);