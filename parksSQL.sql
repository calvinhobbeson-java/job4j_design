create table ParkOne(
id serial primary key,
isExist boolean,
parkName text,
sizeMeters integer
);

select * from parkOne

insert into parkOne (isexist, parkname, sizemeters) values(true, 'Центральный парк', 240);

select * from parkOne;

update parkOne set sizemeters = 340;

select * from parkOne;

delete from parkOne;
 
select * from parkOne;