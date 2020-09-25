CREATE TABLE car(
                    model VARCHAR(20),
                    horsepower SMALLINT,
                    car_year SMALLINT,
                    defects TEXT
);

CREATE TABLE person(
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

INSERT INTO person (first, last, phone) VALUES
('Fischer', 'Madden', +3748835253685),
('Daugherty', 'Kramer', +3748834062455),
('Darla', 'Murphy', +3748985923590),
('Pate','Sharpe',+3748175022515),
('Elvira', 'Fitzgerald', +3749085702839),
('Jackson','Gentry',+3748864702740),
('Alyce', 'Wolf', +3749995533465),
('Laura', 'Bernett', +3748675933492),
('Parker', 'Simon', +3748585912322),
('Rios', 'Lebranc', +3749295992765);


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

ALTER TABLE car
    ADD COLUMN power_level VARCHAR(10);

UPDATE car
SET power_level = 'LOW'
WHERE horsepower < 100;

UPDATE car
SET power_level = 'MEDIUM'
WHERE horsepower >= 100 AND horsepower < 250;

UPDATE car
SET power_level = 'POWERFUL'
WHERE horsepower >= 250;

SELECT * FROM car
WHERE model = 'Mercedes-Benz' and defects = '';