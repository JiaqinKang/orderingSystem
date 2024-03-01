create database if not exists orderingsystem;

use orderingsystem;

create table if not exists loginDetails (
    loginUsername VARCHAR(255) NOT NULL,
    loginPassword VARCHAR(255) NOT NULL
);

create table if not exists foodMenu (
	foodID int auto_increment primary key,
    foodName varchar(255) not null,
    foodPrice decimal(10,2) not null
);
    
create table if not exists drinkMenu(
	drinkID int auto_increment primary key,
    drinkName varchar(255) not null,
    drinkPrice decimal(10,2) not null
);

create table if not exists customers(
	customerID int auto_increment primary key,
    telephoneNumber varchar(20) not null,
    address varchar(255) not null,
    postCodes varchar(10) not null,
    notes text
);

create table if not exists orderHistory(
	orderID int auto_increment primary key,
    customerID int not null,
    orderDate date not null,
    orderTime time not null,
    totalAmount decimal(10,2) not null,
    itemsOrdered text,
    notes text
);

show tables;