drop table if exists users;
create table users(
	id int primary key auto_increment,
	username varchar(30),
	password varchar(64),
	full_name varchar(40),
	create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	last_login TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

drop table if exists roles;
create table roles(
	id int primary key auto_increment,
	role_name varchar(20),
	description varchar(100),
	create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

drop table if exists user_role;
create table user_role(
    id int primary key auto_increment,
    user_id int,
    role_id int
);

drop table if exists orders;
create table orders(
	id int primary key auto_increment,
	order_no varchar(20),
	user_id int,
	amount double,
	order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	status int,
	customer varchar(40)
);

drop table if exists order_line;
create table order_line (
    id int primary key auto_increment,
    product varchar(50),
    amount double,
    quantity int,
    order_id int,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);




