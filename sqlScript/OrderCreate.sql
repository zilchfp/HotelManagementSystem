use HotelManagementSystem;
create table Order(
OrderID varchar(20) primary key,
roomID varchar(20),
customerID varchar(20),
customerName varchar(20),
FOREIGN KEY (roomID) REFERENCES Room(ID),
FOREIGN KEY (customerID) REFERENCES Customer(userID),
FOREIGN KEY (customerName) REFERENCES Customer(customerName),
dateBegin varchar(20),
dateEnd varchar(20),
status varchar(20) not null
);

roomType varchar(20),

);

create table test(
OrderID varchar(20) primary key,
roomID varchar(20) ,
FOREIGN KEY (OrderID) REFERENCES Room(ID)
);
