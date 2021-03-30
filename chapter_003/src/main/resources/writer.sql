create database library;

create table books
(
    id    serial primary key,
    value varchar(50) not null
);

create table writer
(
    id       serial primary key,
    name     varchar(255),
    age      int,
    books_id int references books (id)
);

insert into books(value)
values ('Оно');
insert into books(value)
values ('Гор');
insert into books(value)
values ('Сияние');
insert into books(value)
values ('Сага о Джандаре');

insert into writer(name, age, books_id)
values ('Стивен Кинг', 73, 1);
insert into writer(name, age, books_id)
values ('Стивен Кинг', 73, 3);
insert into writer(name, age, books_id)
values ('Норман Джон', 89, 2);
insert into writer(name, age, books_id)
values ('Норман Джон', 89, 4);
insert into writer(name, age)
values ('Вася Пупкин', 40);

select *
from writer w
         join books b on w.books_id = b.id;

select w.name as nameWriter, b.value as nameBook
from writer w
         join books b on w.books_id = b.id;

select w.name as nameWriter, w.age as ageWriter, b.value as nameBook
from writer w
         join books b on w.books_id = b.id;
