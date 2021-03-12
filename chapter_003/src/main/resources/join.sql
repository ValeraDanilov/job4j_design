create database employees;

create table departments
(
    id   serial primary key,
    name varchar(250)
);

create table employees
(
    id             serial primary key,
    name           varchar(250),
    id_departments int references departments (id)
);

insert into departments (name)
values ('Департамент образования');
insert into departments (name)
values ('Департамент здравоохранения');
insert into departments (name)
values ('Следственный департамент');
insert into departments (name)
values ('Департамент информационных технологий, связи и защиты информации');
insert into departments (name)
values ('Договорно-правовой департамент');

insert into employees (name, id_departments)
values ('Петров Ю.А', 1);
insert into employees (name, id_departments)
values ('Обоженов С.В', 2);
insert into employees (name, id_departments)
values ('Турчинов А.С', 3);
insert into employees (name, id_departments)
values ('Клименко И.А', 4);

--Запрос left.
select *
from departments d
         left join employees e on d.id = e.id_departments;

--Запрос right.
select *
from departments d
         right join employees e on d.id = e.id_departments;

--Запрос full.
select *
from departments d
         full join employees e on d.id = e.id_departments;

--Запрос cross.
select *
from departments d
         cross join employees e;

--Поиск департаменты, у которых нет работников используя left join найти.
select *
from departments d
         left join employees e on d.id = e.id_departments
where e.id_departments is null;

--Используя left и right join написать запросы, которые давали бы одинаковый результат.
select *
from departments d
         left join employees e on d.id = e.id_departments;
select *
from employees e
         left join departments d on e.id_departments = d.id;

select *
from departments d
         right join employees e on d.id = e.id_departments;
select *
from employees e
         right join departments d on e.id_departments = d.id;

--Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары.
create table teens
(
    id     serial primary key,
    name   varchar(100),
    gender varchar(6)
);

insert into teens(name, gender)
values ('Erica', 'female');
insert into teens(name, gender)
values ('Milania', 'female');
insert into teens(name, gender)
values ('Sara', 'female');
insert into teens(name, gender)
values ('Josh', 'male');
insert into teens(name, gender)
values ('Jon', 'male');
insert into teens(name, gender)
values ('Tom', 'male');

select f.name as column_one, m.name as column_two
from teens f
         cross join teens m
where (f.gender != m.gender);
