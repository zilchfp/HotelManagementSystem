select Room.ID,Room.number,Room.type,Room.floor,Room.direction,Room.description,Room.status
from Room
left join Orders
on Orders.type = Room.type
where Orders.OrderID = '123' and Room.status='可用'
