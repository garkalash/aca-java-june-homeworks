-----------------------------------------------First Link

INSERT INTO cd.facilities (facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) VALUES
(9, 'Spa', 20, 30, 100000, 800)

 INSERT INTO cd.facilities (facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) VALUES
(9, 'Spa', 20, 30, 100000, 800), 
(10,'Squash Court 2', 3.5, 17.5, 5000, 80)


insert into cd.facilities
(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance)
values ((select max(facid) from cd.facilities)+1, 'Spa', 20, 30, 100000, 800)

UPDATE cd.facilities
set initialoutlay = 10000 
where facid = 1

update cd.facilities
set guestcost =30, membercost = 6
where name like'Tennis Court%'

update cd.facilities
set membercost = 
((select membercost from cd.facilities where name = 'Tennis Court 1') + (select membercost from cd.facilities where name = 'Tennis Court 1')*0.1),
guestcost =((select guestcost from cd.facilities where name = 'Tennis Court 1') + (select guestcost from cd.facilities where name = 'Tennis Court 1')*0.1)
where name = 'Tennis Court 2'	

DELETE FROM table_name;

delete from cd.members
where memid = 37

delete from cd.members
where memid not in (select memid from cd.bookings)

---------------------------------------------------------Second Link

select * from cd.facilities

select * from cd.facilities

select * from cd.facilities
where membercost > 0


select facid, name, membercost, monthlymaintenance from cd.facilities
where membercost > 0 and membercost <= (monthlymaintenance)/ 50

select * from cd.facilities
where name like '%Tennis%'


select * from cd.facilities
where facid in (1,5)

----------------------- Classify results into buckets

SELECT name, 
CASE
    WHEN monthlymaintenance > 100 THEN 'expensive'
    WHEN monthlymaintenance <= 100 THEN 'cheap'
END AS cost
FROM cd.facilities;


select memid, surname, firstname, joindate from cd.members
where joindate >= CAST('2012-09-01' AS timestamp)

select distinct surname from cd.members
order by surname
limit 10


-----------------------------------Combining results
select surname  from cd.members
UNION
SELECT name as surname FROM cd.facilities;

select joindate from cd.members
where memid = (select max(memid) from cd.members)

select firstname, surname, joindate from cd.members
where memid = (select max(memid) from cd.members)


-----------------------------------------------------Third Link

select count(*) from cd.facilities

select count(*) from cd.facilities
where guestcost >= 10


select recommendedby, count(*) from cd.members
where recommendedby > 0
group by recommendedby
order by recommendedby


select facid, sum(slots) from cd.bookings
group by facid
order by facid


select facid, sum(slots) as slots  from cd.bookings
where cast(starttime as text) like ('2012-09%')
group by facid
order by slots


select facid, EXTRACT(MONTH FROM starttime) as month, sum(slots)as slots from cd.bookings
where EXTRACT(YEAR FROM starttime) = 2012
group by facid, month
order by facid, month


select count(memid) from (select memid, count(starttime) from cd.bookings
group by memid)as b


select facid, slots from(
select facid, sum(slots) as slots from cd.bookings
group by facid) as b
where slots >= 1000
order by facid


select  facid, sum(slots) as slots from cd.bookings
group by facid
order by slots desc
limit 1


