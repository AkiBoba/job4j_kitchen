create table IF NOT EXISTS orders(
    id serial primary key not null,
    dishId int not null
);