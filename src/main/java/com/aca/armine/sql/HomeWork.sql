CREATE TABLE car
(
    id          serial,
    model       varchar(20),
    horse_power varchar(10),
    car_year    smallint,
    price       numeric,
    defects     text
);

ALTER TABLE car
    RENAME column horse_power to power_level;



INSERT INTO car
VALUES (DEFAULT, 'Mercedes Benz', 'POWERFULL', 2009, 8138.46, 'bad engine'),
       (DEFAULT, 'Mercedes Benz', 'MEDIUM', 2007, 9868.67, null),
       (DEFAULT, 'Mercedes Benz', 'POWERFULL', 2005, 70340.46, 'bad engine, minor scratches, crashed'),
       (DEFAULT, 'Honda', 'MEDIUM', 2002, 8926.07, 'bad engine'),
       (DEFAULT, 'Lexus', 'POWERFULL', 2000, 10670.90, 'bad engine'),
       (DEFAULT, 'Toyota', 'POWERFULL', 1999, 5207.37, null),
       (DEFAULT, 'Lexus', 'POWERFULL', 2015, 11075.75, 'bad engine, minor scratches'),
       (DEFAULT, 'Toyota', 'POWERFULL', 1999, 6491.89, 'bad engine, minor scratches, crashed'),
       (DEFAULT, 'Toyota', 'POWERFULL', 1998, 6469.74, 'bad engine, minor scratches'),
       (DEFAULT, 'Lexus', 'POWERFULL', 2003, 13523.29, 'bad engine, minor scratches, crashed'),
       (DEFAULT, 'Lexus', 'POWERFULL', 2015, 13525.56, 'bad engine'),
       (DEFAULT, 'Lada', 'POWERFULL', 2011, 7204.93, 'bad engine, minor sor scratches'),
       (DEFAULT, 'Toyota', 'POWERFULL', 2015, 12484.50, 'bad engine, minor scratches, crashed'),
       (DEFAULT, 'Lada', 'POWERFULL', 2013, 14141.00, 'bad engine, minor scratches, crashed'),
       (DEFAULT, 'Lada', 'POWERFULL', 2003, 11227.16, 'bad engine');

SELECT * From car
WHERE defects is null
  and model = 'Mercedes Benz';

CREATE TABLE person
(
    id         serial,
    first_name varchar(15),
    last_name  varchar(15),
    phone      text,
    buyer      boolean,
    seller     boolean
);
INSERT INTO person
VALUES (DEFAULT, 'Fischer', 'Madden', '+374 (883) 525-3685', true, false),
       (DEFAULT, 'Daugherty', 'Kramer', '+374 (883) 403-2455', false, true),
       (DEFAULT, 'Darla', 'Murphy', '+374 (898) 592-3590', true, false),
       (DEFAULT, 'Pate', 'Sharpe', '+374 (817) 502-2515', false, true),
       (DEFAULT, 'Elvira', 'Fitzgerald', '+374 (908) 570-2839', true, false),
       (DEFAULT, 'Jackson', 'Gentry', '+374 (886) 470-27405', false, true),
       (DEFAULT, 'Alyce', 'Wolf', '+374 (999) 553-3465', true, false),
       (DEFAULT, 'Laura', 'Barnett', '+374 (867) 593-3492', false, true),
       (DEFAULT, 'Parker', 'Simon', '+374 (858) 591-2322', true, false),
       (DEFAULT, 'Rios', 'Leblanc', '+374 (929) 599-2765', false, true),
       (DEFAULT, 'Rita', 'Cooley', '+374 (961) 407-3464', true, false),
       (DEFAULT, 'Mathis', 'Noel', '+374 (917) 400-3957', false, true),
       (DEFAULT, 'Charles', 'Copeland', '+374 (885) 503-3097', true, false),
       (DEFAULT, 'Ashlee', 'Holloway', '+374 (814) 543-3360', false, true),
       (DEFAULT, 'Espinoza', 'Haney', '+374 (889) 569-3561', true, false),
       (DEFAULT, 'Ware', 'Trevino', '+374 (898) 444-2283', false, true);

CREATE TABLE deal
(
    id          serial,
    soled_date  date,
    soled_car   varchar(20),
    deal_amount numeric,
    buyer_name  varchar(20),
    seller_name varchar(20)
);

INSERT INTO deal
VALUES (DEFAULT, '2020-08-27', 'Mercedes Benz', 8138.46, 'Madden', 'Kramer'),
       (DEFAULT, '2020-08-28', 'Mercedes Benz', 9868.67, 'Murphy', 'Sharpe'),
       (DEFAULT, '2020-08-23', 'Mercedes Benz', 70340.46, 'Fitzgerald', 'Gentry'),
       (DEFAULT, '2020-08-30', 'Honda', 8926.07, 'Wolf', 'Barnett'),
       (DEFAULT, '2020-08-12', 'Lexus', 10670.90, 'Simon', 'Leblanc'),
       (DEFAULT, '2020-08-17', 'Toyota', 5207.37, 'Cooley', 'Noel'),
       (DEFAULT, '2020-08-19', 'Lexus', 11075.75, 'Copeland', 'Haney'),
       (DEFAULT, '2020-08-28', 'Toyota', 6491.89, 'Espinoza', 'Trevino'),
       (DEFAULT, '2020-08-26', 'Toyota', 6469.74, 'Graham', 'Glover'),
       (DEFAULT, '2020-08-22', 'Lexus', 13523.29, 'Erickson', 'Weeks'),
       (DEFAULT, '2020-08-21', 'Lexus', 13525.56, 'Haynes', 'Norris'),
       (DEFAULT, '2020-08-25', 'Toyota', 12484.50, 'Lindsey', 'Cooke'),
       (DEFAULT, '2020-08-17', 'Lada', 7204.93, 'Price', 'Frank'),
       (DEFAULT, '2020-08-15', 'Lada', 14141.00, 'Harrison', 'Glass'),
       (DEFAULT, '2020-08-28', 'Lada', 11227.16, 'Nunez', 'Boyer');

