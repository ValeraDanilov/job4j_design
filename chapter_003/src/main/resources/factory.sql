create database factory;

create table engine
(
    id    serial primary key,
    value varchar(50) not null
);

create table gearbox
(
    id    serial primary key,
    value varchar(50) not null
);

create table body
(
    id    serial primary key,
    value varchar(50) not null
);

create table car
(
    id         serial primary key,
    name       varchar(50) not null,
    id_engine  int references engine (id),
    id_gearbox int references gearbox (id),
    id_body    int references body (id)
);

insert into engine (value)
values ('gasoline');
insert into engine (value)
values ('gasoline');
insert into engine (value)
values ('gasoline');

insert into gearbox (value)
values ('automatic');
insert into gearbox (value)
values ('automatic');
insert into gearbox (value)
values ('mechanics');

insert into body (value)
values ('Audi a8');
insert into body (value)
values ('BMW X4');

insert into car (name, id_engine, id_gearbox, id_body)
values ('Audi', 4, 4, 1);
insert into car (name, id_engine, id_gearbox, id_body)
values ('BMW', 5, 5, 2);

select c.name as car, e.value as engine, g.value as gearbox, b.value as body
from car c
         join engine e on c.id_engine = e.id
         join gearbox g on c.id_gearbox = g.id
         join body b on b.id = c.id_body;

select e.value, e.id
from engine e
         left join car c on c.id_engine = e.id
where c.id IS NULL;

select g.value, g.id
from gearbox g
         left join car c on c.id_engine = g.id
where c.id IS NULL;
