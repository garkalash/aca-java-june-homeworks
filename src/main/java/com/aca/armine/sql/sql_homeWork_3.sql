--Classify results into buckets
SELECT name, CASE
    WHEN monthlymaintenance > 100 THEN 'expensive' ELSE 'cheap' END
from cd.facilities;

--Combining results from multiple queries
SELECT surname as members_and_facilities
from cd.members
UNION
SELECT name from cd.facilities;

--1. Find the total revenue of each facility
SELECT cd.facilities.name as name,
       sum(cd.bookings.slots * CASE
                                   WHEN cd.bookings.memid = 0
                                       then cd.facilities.guestcost
                                   ELSE cd.facilities.membercost end)
                          as revenue
from cd.bookings
         INNER JOIN cd.facilities on cd.bookings.facid = cd.facilities.facid
group by name
order by revenue;


--2.Find facilities with a total revenue less than 1000
SELECT name, revenue
from (SELECT cd.facilities.name as name,
             sum(cd.bookings.slots * CASE
                                         WHEN cd.bookings.memid = 0
                                             then cd.facilities.guestcost
                                         else cd.facilities.membercost end)
                                as revenue
      from cd.bookings
               INNER JOIN cd.facilities on cd.bookings.facid = cd.facilities.facid
      group by name) as aa
WHERE revenue <= 1000
order by revenue;


--3.Output the facility id that has the highest number of slots booked

Select facid, sum(slots) as maxSlots
from cd.bookings
group by facid
having sum(slots) = (SELECT max(maxSlots)
                     from (SELECT sum(slots) as maxSlots
                           from cd.bookings
                           group by facid) as aa);


--4.List the total slots booked per facility per month, part 2
SELECT facid, extract(MONTH FROM starttime) as month, sum(slots) as slots
from cd.bookings
WHERE extract(year FROM starttime) = 2012
group by Rollup (facid, month)
order by facid, month;


--5.List the total hours booked per named facility
SELECT fcl.facid,
       fcl.name as name,
       (Select CAST(sum(slots) * 0.5 as decimal(10, 2)))
                as total_hours
from cd.bookings book
         INNER JOIN cd.facilities fcl on book.facid = fcl.facid
group by fcl.facid, fcl.name
order by fcl.facid;


--6List each member's first booking after September 1st 2012
SELECT mmb.surname,
       mmb.firstname,
       mmb.memid,
       min(book.starttime)
           as first_booking_date
from cd.bookings book
         INNER JOIN cd.members mmb on book.memid = mmb.memid
WHERE extract(Month from book.starttime) >= 9
  and extract(year from book.starttime) >= 2012
group by mmb.surname, mmb.firstname, mmb.memid
order by mmb.memid;

--7.Produce a list of member names, with each row containing the total member count
SELECT (SELECT count(*) from cd.members) as members_count, firstname, surname
from cd.members
order by joindate;


--8.Produce a list of member names, with each row containing the total member count
SELECT (SELECT count(memid) from cd.members), firstname, surname
from cd.members
order by joindate;
--9.Produce a numbered list of members

SELECT row_number() over () as id, firstname, surname
from cd.members
order by joindate;
--9.-2

SELECT rank() over (order by memid) as id, firstname, surname
from cd.members
order by joindate;


--10.Output the facility id that has the highest number of slots booked, again
SELECT facid, sum(slots) as maxSlots
from cd.bookings
group by facid
having sum(slots) = (SELECT max(maxSlots)
                     from (SELECT sum(slots) as maxSlots
                           from cd.bookings
                           group by facid) as aa);

--10.2
SELECT facid, maxLots
from (SELECT facid,
             sum(slots)                             as maxLots,
             rank() over (order by sum(slots) desc) as rank
      from cd.bookings
      group by facid
     ) as ranking
WHERE rank = 1;

--11.Rank members by (rounded) hours used
SELECT firstname,
       surname,
       total_hours,
       rank() over (order by total_hours desc) as rank
from (SELECT mmb.surname,
             mmb.firstname,
             (SELECT ((sum(slots) + 10) / 20) * 10)
                 as total_hours
      from cd.bookings book
               INNER JOIN cd.members mmb
                          on book.memid = mmb.memid
      group by mmb.surname, mmb.firstname) as aa
order by rank, firstname, surname;

--12.Find the top three revenue generating facilities
SELECT fcl.name as name,
       Rank() Over (order by sum(book.slots *
                                 CASE
                                     WHEN book.memid = 0
                                         then fcl.guestcost
                                     else fcl.membercost end) desc)
                as revenue
from cd.bookings book
         INNER JOIN cd.facilities fcl on book.facid = fcl.facid
group by name
order by revenue
LIMIT 3;

--13.Classify facilities by value
SELECT name,
       CASE
           WHEN rank = 1 then 'high'
           WHEN rank = 2 then 'average'
           else 'low' end as level
from (SELECT fcl.name                                                       as name,
             ntile(3) over (order by sum(book.slots *
                                         CASE
                                             WHEN book.memid = 0
                                                 then fcl.guestcost
                                             else fcl.membercost end) desc) as rank
      from cd.bookings book
               INNER JOIN cd.facilities fcl
                          on book.facid = fcl.facid
      group by name) as aa
order by rank, name;


--14.Calculate the payback time for each facility
SELECT fcl.name as name,
       fcl.initialoutlay / (sum(book.slots *
                                CASE
                                    WHEN book.memid = 0
                                        then fcl.guestcost
                                    else fcl.membercost end) / 3)
                as month
from cd.bookings book
         INNER JOIN cd.facilities fcl
                    on book.facid = fcl.facid
group by fcl.facid
order by name;

--15.Calculate a rolling average of total revenue
SELECT august.date,
       ((SELECT sum(CASE
                       WHEN memid = 0 THEN slots * fcl.guestcost
                       ELSE slots * membercost
           END) as aa

        from cd.bookings book
                 INNER JOIN cd.facilities fcl
                            ON book.facid = fcl.facid
        WHERE book.starttime > august.date - interval '14 days'
          and book.starttime < august.date + interval '1 day'
       ) / 15) as revenue
from (SELECT cast(generate_series(timestamp '2012-08-01',
                                     '2012-08-31', '1 day') as date) as date
     ) as august
order by august.date;