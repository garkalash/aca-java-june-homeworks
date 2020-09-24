DROP DATABASE homework_1_db;

--Create Car, Person and Deal tables
CREATE TABLE car(
    model VARCHAR(20),
    horsepower SMALLINT,
    car_year SMALLINT,
    defects TEXT
);

CREATE TABLE person(
    ID VARCHAR(6),
    first VARCHAR(20),
    last VARCHAR(20),
    phone BIGINT
);

CREATE TABLE deal(
    id varchar(24),
    price MONEY,
    sold_date TIMESTAMP
);

alter TABLE person
alter COLUMN first TYPE VARCHAR(15);

--insert first 15 items from json into  tables using queries
INSERT INTO car (model, horsepower, car_year, defects) VALUES
     ('Mercedes-Benz', 251, 2009, 'bad_engine'),
     ('Mercedes-Benz', 144, 2007, ''),
     ('Mercedes-Benz', 345, 2005, 'bad_engine, minor_scratches, crashed'),
     ('Honda', 126, 2002, 'bad_engine'),
     ('Lexus', 468, 2000, 'bad_engine'),
     ('Toyota', 298, 1999, ''),
     ('Lexus', 208, 2015, '"bad_engine, minor_scratches'),
     ('Toyota', 724, 1999, 'bad_engine, minor_scratches, crashed'),
     ('Toyota', 629, 1998, 'bad_engine, minor_scratches'),
     ('Lexus', 527, 2003, 'bad_engine, minor_scratches, crashed');

INSERT INTO person (ID, first, last, phone) VALUES
    ('buyer','Fischer', 'Madden', +3748835253685),
    ('seller','Daugherty', 'Kramer', +3748834062455),
    ('buyer','Darla', 'Murphy', +3748985923590),
    ('seller','Pate','Sharpe',+3748175022515),
    ('buyer','Elvira', 'Fitzgerald', +3749085702839),
    ('seller', 'Jackson','Gentry',+3748864702740),
    ('buyer', 'Alyce', 'Wolf', +3749995533465),
    ('seller', 'Laura', 'Bernett', +3748675933492),
    ('buyer','Parker', 'Simon', +3748585912322),
    ('seller','Rios', 'Lebranc', +3749295992765),
    ('buyer', 'Rita', 'Cooley', +3744073464),
    ('seller', 'Mathis', 'Noel', +3749174003957),
    ('buyer', 'Charles', 'Copeland', +3748855033097),
    ('seller', 'Ashlee', 'Holloway', +3748145433360),
    ('buyer', 'Espinoza', 'Haney', +3748895693561),
    ('seller', 'Ware', 'Trevino', +3748984442283),
    ('buyer', 'Ashley', 'Graham', +3749655633736),
    ('seller', 'Lillie', 'Glover', +3748265513316),
    ('buyer', 'Wilkerson', 'Erickson', +3749235502038),
    ('seller', 'Marylou', 'Weeks', +3749075612320);


INSERT INTO deal(id, price, sold_date) VALUES
('5f2e323be953c1e0df570b23', 8138.46, '2020-08-27 11:00:50.544'),
('5f2e323b2c134081040967b3', 9868.67, '2020-08-28T01:43:57.039'),
('5f2e323b965f7522c242762e', 7340.46, '2020-08-23T00:48:29.064'),
('5f2e323b9100901afa17ca11', 8926.07, '2020-08-30T06:28:49.499'),
('5f2e323b5f5a811643e011b1', 10670.98, '2020-08-12T10:41:45.215'),
('5f2e323b5aa6b6430122e0f3', 5207.37, '2020-08-17T00:03:50.238'),
('5f2e323be77d31d586054202', 11075.75, '2020-08-19T01:32:15.201'),
('5f2e323bbf37e79244024f31', 6491.89, '2020-08-28T04:44:36.265'),
('5f2e323b5c027b9006102d04', 6469.74, '2020-08-26T03:32:49.519'),
('5f2e323b20bb2243ca9385a2', 13523.29, '2020-08-22T01:28:34.034');

--1.Add column power_level to Car table
ALTER TABLE car
ADD COLUMN power_level VARCHAR(10);

--2.Fill it with this principle,
-- if horsePower < 100 => LOW, horsePower >=100 AND <250 - MEDIUM otherwise set POWERFULL
UPDATE car
SET power_level = 'LOW'
    WHERE horsepower < 100;

UPDATE car
SET power_level = 'MEDIUM'
    WHERE horsepower >= 100 AND horsepower < 250;

UPDATE car
SET power_level = 'POWERFULL'
    WHERE horsepower >= 250;

--3.Write query to select Mercedeses with no defects
SELECT *FROM car
WHERE model = 'Mercedes-Benz' and defects = '';

SELECT *FROM person;

