CREATE TABLE Books(bid INTEGER PRIMARY KEY, ISBN INTEGER, pid  INTEGER, author CHAR(30), title CHAR(40));
INSERT INTO Books VALUES(11111, 123456789, 5552, 'Cay Horstmann', 'Big Java');
INSERT INTO Books VALUES(22222, 234523897, 6587, 'Philip M. Lewis', 'Database and Transaction Processing');
INSERT INTO Books VALUES(33333, 135754523, 8567, 'Mark Birbeck', 'Professional XML 2nd Edition');
INSERT INTO Books VALUES(44444, 458734515, 5552, 'Damon Hougland', 'Core JSP');
INSERT INTO Books VALUES(55555, 123456789, -1, 'Cay Horstmann', 'Big Java');
INSERT INTO Books VALUES(66666, 458734515, -1, 'Damon Hougland', 'Core JSP');
