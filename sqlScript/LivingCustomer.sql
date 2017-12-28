select 	userID,IDNumber,Customer.customerName,roomID,dateBegin,dateEnd 
from Customer 
left join Orders 
on Customer.userID = Orders.customerID 
where (Orders.status='LIVING')
order by userID
;


select userID,IDNumber,Customer.customerName,roomID,dateBegin
from Customer
left join Orders
on Customer.userID = Orders.customerID
where (Orders.status='LIVING')
order by userID;
