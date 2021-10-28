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
FOREIGN KEY (ItemsId) REFERENCES items(itemId),
FOREIGN KEY (orderId) REFERENCES orders(orderId));


SELECT * FROM orders;
SELECT * FROM customers;
SELECT * FROM items;
SELECT * FROM orderitems;


/* testing the syntax of queries*/
/*UPDATE  orders SET totalValue = totalValue + ? WHERE orderId = ?;*/

/*SELECT * FROM  orderitems JOIN items ON orderitems.ItemsId = items.itemId JOIN orders ON */

/*SELECT value FROM items JOIN orderitems ON items.itemId = orderitems.itemsId WHERE orderId = 1;
*/
SELECT SUM(value) AS total FROM items JOIN orderItems AS oI ON items.itemId = oI.itemsId WHERE orderId = ?;







