use HotelManagementSystem;
create table Room(
ID Varchar(20) primary key,
number Varchar(20) not null,
type Varchar(20) not null,
floor Varchar(20) not null,
direction Varchar(20) not null,
description Varchar(20) ,
status Varchar(20) not null 
);

insert into Room values (2,401,"Standard",4,"NORTH","big room","AVALIABLE");

