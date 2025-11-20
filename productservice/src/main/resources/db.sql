-- Create Categories
INSERT INTO category (id, name, description) VALUES (1, 'Electronics', 'Devices and gadgets like phones, laptops, and accessories');
INSERT INTO category (id, name, description) VALUES (2, 'Books', 'Educational, fictional, and non-fictional books');
INSERT INTO category (id, name, description) VALUES (3, 'Clothing', 'Men and women apparel');
INSERT INTO category (id, name, description) VALUES (4, 'Groceries', 'Daily household and food items');

-- Insert Products for Electronics
INSERT INTO product (id, name, description, avialableQuantity, price, category_id) 
VALUES (1, 'Smartphone', 'Latest Android smartphone with 128GB storage', 50, 29999.00, 1);

INSERT INTO product (id, name, description, avialableQuantity, price, category_id) 
VALUES (2, 'Laptop', '15-inch laptop with Intel i7 processor', 20, 75999.00, 1);

INSERT INTO product (id, name, description, avialableQuantity, price, category_id) 
VALUES (3, 'Wireless Earbuds', 'Noise-cancelling Bluetooth earbuds', 100, 4999.00, 1);

-- Insert Products for Books
INSERT INTO product (id, name, description, avialableQuantity, price, category_id) 
VALUES (4, 'Java Programming', 'Comprehensive guide to Java programming', 200, 799.00, 2);

INSERT INTO product (id, name, description, avialableQuantity, price, category_id) 
VALUES (5, 'Spring Boot in Action', 'Book on building applications with Spring Boot', 150, 999.00, 2);

-- Insert Products for Clothing
INSERT INTO product (id, name, description, avialableQuantity, price, category_id) 
VALUES (6, 'Men T-Shirt', 'Cotton round-neck T-shirt', 300, 499.00, 3);

INSERT INTO product (id, name, description, avialableQuantity, price, category_id) 
VALUES (7, 'Women Dress', 'Stylish summer dress', 120, 1499.00, 3);

-- Insert Products for Groceries
INSERT INTO product (id, name, description, avialableQuantity, price, category_id) 
VALUES (8, 'Rice 5kg Pack', 'Premium quality basmati rice', 80, 699.00, 4);

INSERT INTO product (id, name, description, avialableQuantity, price, category_id) 
VALUES (9, 'Olive Oil 1L', 'Extra virgin olive oil', 60, 499.00, 4);
