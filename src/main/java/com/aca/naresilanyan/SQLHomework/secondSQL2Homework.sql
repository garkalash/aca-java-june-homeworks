select name, revenue from(
select name, sum(case when memid = 0 then slots * guestcost
				else slots * membercost
				end) as revenue from cd.facilities a
inner join cd.bookings b on a.facid = b.facid
group by name
order by revenue) k
where revenue < 1000


select facid, month, sum(slots) as slots from(
select facid, EXTRACT(MONTH FROM starttime) as month , slots  from cd.bookings where starttime >= '2012-01-01' and starttime < '2013-01-01'
union all
select facid, null, slots from cd.bookings where starttime >= '2012-01-01' and starttime < '2013-01-01'
union all
select null, null, sum(slots) as slots from cd.bookings where starttime >= '2012-01-01' and starttime < '2013-01-01') d
group by facid, month
order by facid, month


select a.facid, b.name,  sum(slots * 0.50) as Hours  from cd.bookings a
inner join cd.facilities b on a.facid = b.facid
group by a.facid, b.name
order by a.facid;


select surname, firstname, a.memid, min(starttime) from cd.bookings a
inner join cd.members b on a.memid = b.memid
where a.starttime >= '2012-09-01'
group by surname, firstname, a.memid
order by a.memid


select (select count(memid) from cd.members), firstname, surname from cd.members
order by joindate


select  ROW_NUMBER() OVER(ORDER BY joindate ASC) AS Row,
firstname, surname
from cd.members


select facid, sum(slots) as total from cd.bookings 
group by facid
order by total desc
limit 1


select firstname, surname, round(sum(slots*0.5), -1) as hours,
rank() OVER(ORDER BY round(sum(slots*0.5), -1) desc) AS Row from cd.members a
inner join cd.bookings b on a.memid = b.memid
group by a.memid
order by row, surname, firstname



select name, rank() OVER(ORDER BY revenue desc) from(
select name, sum(case when memid = 0 then slots * guestcost
				else slots * membercost
				end) as revenue from cd.facilities a
inner join cd.bookings b on a.facid = b.facid
group by name
order by revenue desc) k
limit 3


-- -- -- -- -- -- -- -- -- -- ?????????????????????
select name, (case when row between 1 and 3 then 'high'
			 when row between 4 and 6 then 'average'
			 else 'low'
			 end) as revenue from(

	select name, revenue , ROW_NUMBER() OVER(ORDER BY revenue desc) as row from(
	  select name, sum(case when memid = 0 then slots * guestcost
					  else slots * membercost
					  end) as revenue from cd.facilities a
	  inner join cd.bookings b on a.facid = b.facid
	  group by name)k
			 ) f
order by row , name

-- -- -- -- -- -- -- -- -- -- ?????????????????????
select 	name , initialoutlay/((sum(case
			when memid = 0 then slots * guestcost
			else slots * membercost
		end)/3) - monthlymaintenance) as months
	from cd.bookings b
	inner join cd.facilities a
		on b.facid = a.facid
	group by a.facid
order by name


