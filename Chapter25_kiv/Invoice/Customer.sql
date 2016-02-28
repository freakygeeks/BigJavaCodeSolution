CREATE TABLE Customer (Customer_Number INTEGER, Name CHAR(40), Address CHAR(40), City CHAR(30), State CHAR(2), Zip CHAR(10));
INSERT INTO Customer VALUES (3175, 'Sam Small Appliances', '100 Main Street', 'Anytown', 'CA', '98765');
INSERT INTO Customer VALUES (3176, 'Electronics Unlimited', '1175 Liberty Ave', 'PleasantVille', 'MI', '45066');
SELECT * FROM Customer;