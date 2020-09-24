CREATE SCHEMA car_sale;

CREATE TABLE car_sale.car

(
    id          serial,
    model       varchar(20),
    car_year    smallint,
    price       numeric,
    defects     text[],
    horse_power numeric

);



INSERT INTO car_sale.car
VALUES (DEFAULT, 'Mercedes Benz', 2009, 8138.46, '{bad engine}', 251 ),
       (DEFAULT, 'Mercedes Benz', 2007, 9868.67, null, 144),
       (DEFAULT, 'Mercedes Benz', 2005, 70340.46, '{bad engine, minor scratches, crashed}', 345),
       (DEFAULT, 'Honda', 2002, 8926.07, '{bad engine}', 126),
       (DEFAULT, 'Lexus', 2000, 10670.90, '{bad engine}', 468),
       (DEFAULT, 'Toyota', 1999, 5207.37, null, 298),
       (DEFAULT, 'Lexus', 2015, 11075.75, '{bad engine, minor scratches}', 208),
       (DEFAULT, 'Toyota', 1999, 6491.89, '{bad engine, minor scratches}', 724),
       (DEFAULT, 'Toyota', 1998, 6469.74, '{bad engine, minor scratches}', 629),
       (DEFAULT, 'Lexus', 2003, 13523.29, '{bad engine, minor scratches, crashed}', 527),
       (DEFAULT, 'Lexus', 2015, 13525.56, '{bad engine}', 315),
       (DEFAULT, 'Lada', 2011, 7204.93, '{bad engine, minor scratches}', 747),
       (DEFAULT, 'Toyota', 2015, 12484.50, '{bad engine, minor scratches, crashed}', 586),
       (DEFAULT, 'Lada', 2013, 14141.00, '{bad engine, minor scratches, crashed}', 565),
       (DEFAULT, 'Lada', 2003, 11227.16, '{bad engine}', 759);

ALTER TABLE car_sale.car
    add column power_level varchar(10);

UPDATE car_sale.car
    SET power_level = CASE
    WHEN horse_power < 100 THEN 'LOW'
    WHEN horse_power >= 100 and horse_power < 250 THEN 'MEDIUM'
    ELSE 'POWERFULL'
END;



SELECT *
From car_sale.car
WHERE defects is null
  and model = 'Mercedes Benz';

CREATE TABLE car_sale.person
(
    id         serial,
    first_name varchar(15),
    last_name  varchar(15),
    phone      text

);
INSERT INTO car_sale.person
VALUES (DEFAULT, 'Fischer', 'Madden', '+374 (883) 525-3685'),
       (DEFAULT, 'Daugherty', 'Kramer', '+374 (883) 403-2455'),
       (DEFAULT, 'Darla', 'Murphy', '+374 (898) 592-3590'),
       (DEFAULT, 'Pate', 'Sharpe', '+374 (817) 502-2515'),
       (DEFAULT, 'Elvira', 'Fitzgerald', '+374 (908) 570-2839'),
       (DEFAULT, 'Jackson', 'Gentry', '+374 (886) 470-27405'),
       (DEFAULT, 'Alyce', 'Wolf', '+374 (999) 553-3465'),
       (DEFAULT, 'Laura', 'Barnett', '+374 (867) 593-3492'),
       (DEFAULT, 'Parker', 'Simon', '+374 (858) 591-2322'),
       (DEFAULT, 'Rios', 'Leblanc', '+374 (929) 599-2765'),
       (DEFAULT, 'Rita', 'Cooley', '+374 (961) 407-3464'),
       (DEFAULT, 'Mathis', 'Noel', '+374 (917) 400-3957'),
       (DEFAULT, 'Charles', 'Copeland', '+374 (885) 503-3097'),
       (DEFAULT, 'Ashlee', 'Holloway', '+374 (814) 543-3360'),
       (DEFAULT, 'Espinoza', 'Haney', '+374 (889) 569-3561'),
       (DEFAULT, 'Ware', 'Trevino', '+374 (898) 444-2283');

CREATE TABLE car_sale.deal
(
    id          serial,
    soled_date  date,
    soled_car   varchar(20),
    deal_amount numeric,
    buyer_id  smallint,
    seller_id smallint
);

INSERT INTO car_sale.deal
VALUES (DEFAULT, '2020-08-27', 'Mercedes Benz', 8138.46, 1, 2),
       (DEFAULT, '2020-08-28', 'Mercedes Benz', 9868.67, 3, 4),
       (DEFAULT, '2020-08-23', 'Mercedes Benz', 70340.46, 5, 6),
       (DEFAULT, '2020-08-30', 'Honda', 8926.07, 7, 8),
       (DEFAULT, '2020-08-12', 'Lexus', 10670.90, 9, 10),
       (DEFAULT, '2020-08-17', 'Toyota', 5207.37, 11, 12),
       (DEFAULT, '2020-08-19', 'Lexus', 11075.75, 13, 14),
       (DEFAULT, '2020-08-28', 'Toyota', 6491.89, 15 , 16);

