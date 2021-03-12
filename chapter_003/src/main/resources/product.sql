create
    database shop;

create table type
(
    id   serial primary key,
    name varchar(250)
);

create table product
(
    id           serial primary key,
    name         varchar(250),
    type_id      int references type (id),
    expired_date date,
    price        int
);

insert into type(name)
values ('Молочка');
insert into type(name)
values ('Мучные');
insert into type(name)
values ('Овощи');
insert into type(name)
values ('Фрукты');
insert into type(name)
values ('Безалкогольные напитки');
insert into type(name)
values ('Алкогольные напитки');

insert into product(name, type_id, expired_date, price)
values ('Молоко', '1', '2021-03-15', 40);
insert into product(name, type_id, expired_date, price)
values ('Творог', '1', '2021-03-20', 80);
insert into product(name, type_id, expired_date, price)
values ('Сыр', '1', '2021-04-12', 160);
insert into product(name, type_id, expired_date, price)
values ('Сметана', '1', '2021-04-12', 96);

insert into product(name, type_id, expired_date, price)
values ('Хлеб', '2', '2021-03-09', 76);
insert into product(name, type_id, expired_date, price)
values ('Булочка', '2', '2021-03-08', 23);
insert into product(name, type_id, expired_date, price)
values ('Печенье', '2', '2021-02-28', 120);
insert into product(name, type_id, expired_date, price)
values ('Пицца', '2', '2021-04-12', 300);

insert into product(name, type_id, expired_date, price)
values ('Картошка', '3', '2021-06-07', 130);
insert into product(name, type_id, expired_date, price)
values ('Морковка', '3', '2021-04-12', 210);
insert into product(name, type_id, expired_date, price)
values ('Лук', '3', '2021-03-03', 306);
insert into product(name, type_id, expired_date, price)
values ('Капуста', '3', '2021-04-12', 99);

insert into product(name, type_id, expired_date, price)
values ('Мандарины', '4', '2021-04-12', 200);
insert into product(name, type_id, expired_date, price)
values ('Хурма', '4', '2021-12-20', 180);
insert into product(name, type_id, expired_date, price)
values ('Киви', '4', '2021-01-07', 321);
insert into product(name, type_id, expired_date, price)
values ('Бананы', '4', '2021-04-12', 106);

insert into product(name, type_id, expired_date, price)
values ('Соки', '5', '2021-04-12', 288);
insert into product(name, type_id, expired_date, price)
values ('Минералка', '5', '2021-03-09', 56);
insert into product(name, type_id, expired_date, price)
values ('Чай', '5', '2021-02-24', 101);
insert into product(name, type_id, expired_date, price)
values ('Лимонад', '5', '2021-01-16', 104);

insert into product(name, type_id, expired_date, price)
values ('Виски', '6', '2021-08-20', 5100);
insert into product(name, type_id, expired_date, price)
values ('Водка', '6', '2021-08-21', 2000);
insert into product(name, type_id, expired_date, price)
values ('Мартини', '6', '2021-02-02', 3800);
insert into product(name, type_id, expired_date, price)
values ('Ром', '6', '2021-05-22', 7777);
insert into product(name, type_id, expired_date, price)
values ('Пиво', '6', '2021-04-12', 60);

--1. Написать запрос получение всех продуктов с типом "СЫР"
select *
from product
where type_id = (select id from type where name = 'Молочка');

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select *
from product
where name like '%Сыр%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select name
from product
where (extract(month from expired_date)) = (extract(month from current_date + interval '1 month'));

--4. Написать запрос, который выводит самый дорогой продукт.
select name, price
from product
where price = (select max(price) from product);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select count(name)
from product
where type_id = 1;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select *
from product
where name = 'Сыр'
   or name = 'Молоко';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 4 штук.
select (t.name), count(p.name)
from product p
         join type t on p.type_id = t.id
group by t.name
having count(p.name) < 5;

--8. Вывести все продукты и их тип.
select t.name as type, p.name as product
from product p
         join type t on p.type_id = t.id;
