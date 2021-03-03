create database employed;
create table employed(
    id serial primary key,
    first_name varchar(50),
    last_name varchar(50),
    gender varchar(6),
    email varchar(150),
    ate_of_birth date
);
insert into employed(first_name, last_name, gender, email, date_of_birth) values ('Ira', 'Danilova', 'woman', 'Ira@gmail.com', '11.11.1989');
select * from employed;
update employed set gender = 'Woman';
select * from employed;
delete from employed;
select * from employed;
