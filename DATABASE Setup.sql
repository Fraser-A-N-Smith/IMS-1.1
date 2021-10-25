CREATE DATABASE IF NOT EXISTS IMSproject ;

USE IMSproject;

DROP TABLE IF EXISTS orderitems;
DROP TABLE orders;
DROP TABLE customers;
DROP TABLE items;


CREATE TABLE IF NOT EXISTS customers(
id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
first_name VARCHAR(25),
surname VARCHAR(25));

CREATE TABLE IF NOT EXISTS items(
itemId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
itemName VARCHAR(50),
value INT);

CREATE TABLE IF NOT EXISTS orders(
orderId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
items VARCHAR(255),
customer INT,
FOREIGN KEY (customer) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS orderItems(
orderItemsId INT NOT NULL,
orderId INT,
customerid INT,
PRIMARY KEY (orderItemsId))
/*FOREIGN KEY (orderId) REFERENCES orders(orderId),
FOREIGN KEY (customerid) REFERENCES customers(id))*/














