use HotelManagementSystem;
create table Order(
primary key (ID),
foreign key (roomID) references Room(ID),
foreign key (customerID) references Customer(userID),
foreign key (customerName) references Customer(username),
roomType varchar(20),
dateBegin varchar(20),
dateEnd varchar(20),
);


