create table human(
    id serial primary key,
    name varchar(255)
);

create table emails(
    id serial primary key,
    login varchar(255),
   human_id int references human(id)
);

insert into human(name) values ('Olig');
insert into emails(login, human_id) VALUES ('Yarumen@gmail.com', 1);
