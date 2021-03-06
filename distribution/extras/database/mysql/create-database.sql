create database fancyfoods;
use fancyfoods;

CREATE TABLE FOOD (
	name VARCHAR(255),
	price DECIMAL,
	quantity INT,
	PRIMARY KEY (name)
);
CREATE TABLE CUSTOMER (
	name VARCHAR(255),
	creditLimit DECIMAL,
	balance DECIMAL,
	PRIMARY KEY (NAME)
);

CREATE USER 'fancyfoods'@'%' IDENTIFIED BY 'cipher';
GRANT SELECT, INSERT, UPDATE,DELETE, ON fancyfoods.* TO 'fancyfoods'@'%';