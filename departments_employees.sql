create table departments(
id serial primary key,
name varchar(255)
);

create table employees(
id serial primary key,
name varchar(255),
department_id int references departments(id)
);

insert into departments(name) values ('Antifraud');
insert into departments(name) values ('CPX');
insert into departments(name) values ('Special project');
insert into departments(name) values ('Support');

insert into employees(name, department_id) values ('Sergey', 1);
insert into employees(name, department_id) values ('Daniil', 1);
insert into employees(name, department_id) values ('Roman', 1);
insert into employees(name, department_id) values ('Andrey', 3);
insert into employees(name, department_id) values ('Oksana', 3);
insert into employees(name, department_id) values ('Ivan', 2);
insert into employees(name, department_id) values ('Alina', 2);
insert into employees(name, department_id) values ('Yulia', 2);

select * from departments d left join employees e on e.department_id = d.id;
select * from departments d right join employees e on e.department_id = d.id;
select * from departments d full join employees e on e.department_id = d.id;
select * from departments d cross join employees e;
select * from departments d left join employees e on e.department_id = d.id where e.department_id is null;
select * from departments d left join employees e on e.department_id = d.id where e.department_id is not null;
select * from departments d right join employees e on e.department_id = d.id where e.department_id is not null;

create table teens(
id serial primary key,
name varchar(255),
gender varchar(255)
);

insert into teens(name, gender) values ('Oleg', 'male');
insert into teens(name, gender) values ('Nikita', 'male');
insert into teens(name, gender) values ('Vasiliy', 'male');
insert into teens(name, gender) values ('Sergey', 'male');
insert into teens(name, gender) values ('Olesya', 'female');
insert into teens(name, gender) values ('Yulia', 'female');
insert into teens(name, gender) values ('Alina', 'female');
insert into teens(name, gender) values ('Darya', 'female');

select t1.name, t2.name from teens t1 cross join teens t2 where t1.gender != t2.gender;