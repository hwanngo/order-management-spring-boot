delete from users where 1=1;
insert into users(username, password, full_name) values('admin', '$2y$12$/n7Wru9M6PPot4beZhesY./NEtjL.GPTHye6slnbWl/kwgE47VNjq', 'Admin');
-- username: admin | password: admin
insert into users(username, password, full_name) values('manager', '$2y$12$GB20E5ECa5Mb1.Uatez33.KJQzSKC4HimHnPnT/9QD55d/iZSpNyy', 'Manager');
-- username: manager | password: manager
insert into users(username, password, full_name) values('sale', '$2y$12$wg1kVxsyfARWv/R2DJAqyevtApPXpm6Dvfg9rFvkcX1REfJ8SvLne', 'Sale');
-- username: sale | password: sale

delete from roles where 1=1;
insert into roles(role_name, description) values('ROLE_ADMIN', 'Admin');
insert into roles(role_name, description) values('ROLE_MANAGER', 'Manager');
insert into roles(role_name, description) values('ROLE_SALE', 'Sale');

delete from user_role where 1=1;
insert into user_role(user_id, role_id) values(1, 1);
insert into user_role(user_id, role_id) values(2, 2);
insert into user_role(user_id, role_id) values(3, 3);

delete from orders where 1=1;
insert into orders(order_no, user_id, amount, status, customer) values('OD20200228.01', 1, 1, 1, 'Nguyen Van A');
insert into orders(order_no, user_id, amount, status, customer) values('OD20200228.02', 2, 1, 0, 'Le Hoang B');
insert into orders(order_no, user_id, amount, status, customer) values('OD20200228.03', 3, 1, 0, 'Dao Trung C');
insert into orders(order_no, user_id, amount, status, customer) values('OD20200228.04', 4, 1, 0, 'Dang Nhat D');
insert into orders(order_no, user_id, amount, status, customer) values('OD20200228.05', 5, 1, 0, 'Huynh Minh E');
insert into orders(order_no, user_id, amount, status, customer) values('OD20200228.06', 6, 1, 0, 'Le Van Anh F');
insert into orders(order_no, user_id, amount, status, customer) values('OD20200228.07', 7, 1, 0, 'Pham Van G');
insert into orders(order_no, user_id, amount, status, customer) values('OD20200228.08', 8, 1, 0, 'Nguyen Quoc H');
insert into orders(order_no, user_id, amount, status, customer) values('OD20200228.09', 9, 1, 0, 'Tran Thanh I');
insert into orders(order_no, user_id, amount, status, customer) values('OD20200228.10', 10, 1, 0, 'Nguyen Tho Cong J');

delete from order_line where 1=1;
insert into order_line(product, quantity, amount, order_id) values('iPhone 3', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('iPhone 4', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('iPhone 5', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('iPhone 6', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('iPhone 7', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('iPhone 8', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('iPhone X', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('Samsung Galaxy S', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('Samsung Galaxy S2', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('Samsung Galaxy S3', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('Samsung Galaxy S4', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('Samsung Galaxy S5', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('Samsung Galaxy S6', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('Samsung Galaxy S7', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('Samsung Galaxy S8', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('Samsung Galaxy S9', 5, 15000000, 1);
insert into order_line(product, quantity, amount, order_id) values('Samsung Galaxy S10', 5, 15000000, 1);
