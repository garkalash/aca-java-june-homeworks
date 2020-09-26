--UPDATE
--1. Insert some data into a table
INSERT INTO cd.facilities
VALUES (9, 'Spa', 20, 30, 100000, 800);


--2. Insert multiple rows of data into a table
INSERT INTO cd.facilities
VALUES (9, 'Spa', 20, 30, 100000, 800),
       (10, 'Squash Court 2', 3.5, 17.5, 5000, 80);

--3. Insert calculated data into a table

INSERT INTO cd.facilities
VALUES ((Select (SELECT facid
                 FROM cd.facilities
                 ORDER BY facid
                     DESC
                 LIMIT 1) + 1), 'Spa', 20, 30, 100000, 800);


--4. Update some existing data
Update cd.facilities
set initialoutlay = 8000
where name = 'Tennis Court 2';

--5.Update multiple rows and columns at the same time
UPDATE cd.facilities
set membercost = 6,
    guestcost  = 30
where name like 'Tennis Court _';


--6. Update a row based on the contents of another row
UPDATE cd.facilities
set membercost = (Select membercost
                  from cd.facilities
                  where name = 'Tennis Court 1') * 1.1,
    guestcost  = (Select guestcost
                  from cd.facilities
                  where name = 'Tennis Court 1') * 1.1
where name = 'Tennis Court 2';

--7. Delete all bookings
delete
from cd.bookings;
truncate cd.bookings;

--8. Delete a member from the cd.members table
delete
from cd.members
where memid = 37;

--9. Delete based on a subQuery
SELECT *
from cd.members
where memid not in (select memid from cd.bookings);

--SelectAll
--1. Retrieve everything from a table
SELECT *
from cd.facilities;

--2.Retrieve specific columns from a table
SELECT name, membercost
from cd.facilities;

--3.Control which rows are retrieved
SELECT *
from cd.facilities
WHERE membercost <> 0
  and guestcost <> 0;

--4.Control which rows are retrieved - part 2
SELECT facid, name, membercost, monthlymaintenance
from cd.facilities
WHERE membercost <> 0
  and membercost < monthlymaintenance / 50;

--5.Basic string searches
Select *
from cd.facilities
WHERE name like '%Tennis%';

--6.Matching against multiple possible values
Select *
from cd.facilities
WHERE name like '%2';

--7.Working with dates
SELECT memid, surname, firstname, joindate
from cd.members
WHERE joindate > '2012-09-01 00:00:00';

--8.Removing duplicates, and ordering results
SELECT DISTINCT surname
from cd.members
ORDER BY surname
limit 10;

--9.Simple aggregation
SELECT joindate as latest
from cd.members
WHERE joindate = (Select max(joindate) from cd.members);

--10.More aggregation
SELECT firstname, surname, joindate
from cd.members
WHERE joindate = (Select max(joindate) from cd.members);

--Aggregation
--1. Count the number of facilities
SELECT count(*) as facilityCount
from cd.facilities;

--2.Count the number of expensive facilities
SELECT count(*) as expensiveFacilityCount
from cd.facilities
WHERE guestcost >= 10;

--3.Count the number of recommendations each member makes.
SELECT Distinct recommendedby as id, count(*)
from cd.members
WHERE recommendedby is not null
group by (recommendedby)
ORDER BY recommendedby;

--4.List the total slots booked per facility
SELECT Distinct facid as id, sum(slots) as Total_Slotes
from cd.bookings
group by (facid)
ORDER BY facid;

--5.List the total slots booked per facility in a given month
SELECT Distinct facid as id, sum(slots) as Count_Slotes
from cd.bookings
Where extract(MONTH FROM starttime) = 9
group by (facid)
ORDER BY Count_Slotes;

--6.List the total slots booked per facility per month
SELECT facid                         as id,
       extract(MONTH FROM starttime) as month,
       sum(slots)                    as Count_Slotes
from cd.bookings
WHERE extract(YEAR FROM starttime) = 2012
group by (id, extract(MONTH FROM starttime))
ORDER BY id, month;

--7.Find the count of members who have made at least one booking
SELECT count(*) as total_count
from cd.members
where memid in (select memid from cd.bookings);

--8.List facilities with more than 1000 slots booked
SELECT facid, sum(slots) as Count_Slotes
from cd.bookings
group by (facid)
having sum(slots) > 1000
ORDER BY facid;

