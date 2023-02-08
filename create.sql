create table address (id integer not null auto_increment, city varchar(255), code integer, country varchar(255), house_number integer, suburb varchar(255), user_id integer, primary key (id)) engine=InnoDB
create table orders (id integer not null auto_increment, customer_address varchar(255), customer_numbers varchar(255), status varchar(255), total_price double precision, primary key (id)) engine=InnoDB
create table preped_stock (id integer not null auto_increment, name varchar(255), weight double precision, primary key (id)) engine=InnoDB
create table product (id integer not null auto_increment, category varchar(255), name varchar(255), price double precision, size varchar(255), primary key (id)) engine=InnoDB
create table product_order (orders_id integer not null, products_id integer not null) engine=InnoDB
create table product_toping (products_id integer not null, toping_id integer not null) engine=InnoDB
create table stock_type (id integer not null auto_increment, date varchar(255), name varchar(255), weight double precision, primary key (id)) engine=InnoDB
create table toping (id integer not null auto_increment, name varchar(255), size varchar(255), weight double precision, preped_stock_id integer, primary key (id)) engine=InnoDB
create table user (id integer not null auto_increment, mobile_number varchar(255), name varchar(255), role varchar(255), primary key (id)) engine=InnoDB
alter table address add constraint FKda8tuywtf0gb6sedwk7la1pgi foreign key (user_id) references user (id)
alter table product_order add constraint FKgbrn49w9xlj5xx4nok9wunivv foreign key (products_id) references product (id)
alter table product_order add constraint FKnxb19amwrevbigam8p6n0h12s foreign key (orders_id) references orders (id)
alter table product_toping add constraint FKq3n9hwlgc449w68x16m22vjrc foreign key (toping_id) references toping (id)
alter table product_toping add constraint FKtd8owfacfw2bxba2c15yxiimw foreign key (products_id) references product (id)
alter table toping add constraint FK2kdgqvjc8xl4ej03tq2i6pphf foreign key (preped_stock_id) references preped_stock (id)
