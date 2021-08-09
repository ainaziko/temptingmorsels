CREATE DATABASE TemptingMorsels;
USE TemptingMorsels;

CREATE TABLE Desserts (
                          id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                          dessert_name NVARCHAR(50) NOT NULL unique,
                          dessert_description TEXT,
                          imgPath TEXT NOT NULL,
                          price double NOT NULL
);

CREATE TABLE Soft_Drinks (
                             id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                             drink_name NVARCHAR(50) NOT NULL,
                             drink_description TEXT,
                             imgPath TEXT NOT NULL,
                             price double NOT NULL
);

CREATE TABLE Orders (
                        order_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                        customer_id INT UNSIGNED,
                        order_date datetime,
                        payed boolean
);

CREATE TABLE Customers (
                           id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                           firstname NVARCHAR(80) NOT NULL,
                           lastname NVARCHAR(100) NOT NULL,
                           email NVARCHAR(100) NOT NULL unique,
                           city NVARCHAR(80) NOT NULL
);

CREATE TABLE OrderDetails (
                              order_id INT UNSIGNED,
                              dessert_id INT UNSIGNED,
                              dessert_quantity INT,
                              dessert_price DOUBLE,
                              drink_id INT UNSIGNED,
                              drink_quantity INT,
                              drink_price DOUBLE,
                              total DOUBLE,
                              orderDetailId INT AUTO_INCREMENT PRIMARY KEY
);

ALTER TABLE OrderDetails ADD CONSTRAINT fk_dessert_id FOREIGN KEY (dessert_id) REFERENCES Desserts(id);
ALTER TABLE OrderDetails ADD CONSTRAINT fk_drink_id FOREIGN KEY (drink_id) REFERENCES Soft_Drinks(id);
ALTER TABLE OrderDetails ADD CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES Orders(order_id);
ALTER TABLE Orders ADD CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES Customers(id);