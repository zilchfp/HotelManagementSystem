use HotelManagementSystem;
create table Manager(
ID Varchar(20) primary key,
username Varchar(20) not null,
password Varchar(20) not null,
name Varchar(20) not null,
gender Varchar(20)
);

insert into Manager values ("999","manager","password","LaoWang","Male");

