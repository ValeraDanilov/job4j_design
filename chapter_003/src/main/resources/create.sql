create table roles
(
    id   serial primary key,
    role varchar(50)
);

create table users
(
    id      serial primary key,
    name    varchar(50),
    role_id int references roles (id)
);

create table rules
(
    id   serial primary key,
    rule varchar(2000)
);

create table roles_rules
(
    role_id  int references roles (id),
    rules_id int references rules (id)
);

create table categories
(
    id       serial primary key,
    category varchar(250)
);

create table statuses
(
    id     serial primary key,
    status varchar(100)
);

create table items
(
    id            serial primary key,
    number_items  varchar(100),
    text_items    text,
    user_id       int references users (id),
    categories_id int references categories (id),
    statuses_id   int references statuses (id)
);

create table comments
(
    id       serial primary key,
    comment  varchar(2000),
    items_id int references items (id)
);

create table attached_files
(
    id       serial primary key,
    attached varchar(250),
    items_id int references items (id)
);
