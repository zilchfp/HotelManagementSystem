select * 
from Orders 
left join Room 
on Room.ID=Orders.roomID 
where (Orders.status='FINISHED' or Orders.status='BOOKED' ) and (dateBegin between '12-10-10' and '12-10-20')
group by roomID
order by dateBegin,dateEnd
;
