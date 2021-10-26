CREATE DATABASE IF NOT EXISTS IMSproject ;

USE IMSproject;

DROP TABLE IF EXISTS orderitems;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS items;


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
customerId INT,
FOREIGN KEY (customerId) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS orderItems(
orderItemId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
ItemsId INT NOT NULL,
orderId INT NOT NULL,
FOREIGN KEY (orderId) REFERENCES orders(orderId));


SELECT * FROM orders;
SELECT * FROM customers;
SELECT * FROM items;
SELECT * FROM orderitems;


/* testing the syntax of queries*/
/*UPDATE  orders SET totalValue = totalValue + ? WHERE orderId = ?;*/











