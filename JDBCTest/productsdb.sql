create database productsdb;
use productsdb;
SET GLOBAL time_zone = '-3:00';

create table if not exists products(
	id int auto_increment,
    name varchar(50),
    price decimal,
    brand varchar(80),
    unit varchar(50),
    quantity int,
    discount double,
    constraint pk_id_product primary key (id)
);

select * from products;