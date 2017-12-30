select type,COUNT(roomID) as number
from Customer 
left join Orders 
on Customer.userID = Orders.customerID 
where (Orders.status='在住') and (dateEnd >= '2017-12-01')
group by type;

