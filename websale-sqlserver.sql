create database websale
go

use websale
go

--create account stored username and password
create table account(
	username nchar(100) not null,
	password nchar(100) not null
	primary key (username)
)
go

--create user stored infor account
create table users(
	ID_User int IDENTITY(1, 1) PRIMARY KEY,
	username nchar(100) not null UNIQUE,
	fullname nvarchar(130) not null,
	Addres nvarchar(200) not null,
	phone nchar(14) not null,
	category nchar(6) not null,
	email nchar(50) not null,
	time_create datetime not null,

)
go

--check column category only insert value is user or seller
ALTER TABLE users
ADD CONSTRAINT account_category
check (category IN ('user', 'seller'));
go

--create table seller ,include infor of table users and
-- complement infor of seller  
create table seller(
    ID_Seller int identity(1,1) primary key,
	username nchar(100) not null unique,
	ID_Card nchar(20) not null unique
)
go

--stored avatar of user
create table avatar(
	username nchar(100) not null primary key,
	name_image varchar(max) not null
)
go

--add fk for avatar , link to table user
ALTER TABLE avatar
ADD FOREIGN KEY (username) REFERENCES users(username)
go

--create foreign key for link table users to primary key of table account
--relationship 1-1
ALTER TABLE users
ADD FOREIGN KEY (username) REFERENCES account(username)
GO

--link ID of avatar to ID of users (1-1)
ALTER TABLE avatar
ADD FOREIGN KEY (ID_user) REFERENCES users(ID_User)
GO

--foreign key link table seller with users
--relationship 1-1
ALTER TABLE seller
ADD FOREIGN KEY (username) REFERENCES users(username)
GO

insert into account values('dung11b4', '123456')
go

insert into account values('dung13c4', '123456')
go

insert into users values('dung13c4', N'phạm đăng dũng', N'Định Công - Yên Định - Thanh Hóa', '0385685581', 'seller', 'dungcute562211@gmail.com', '2022-12-05 12:34:45')
go

insert into seller values ('dung13c4', '032154545454')
go

--fetch infor users (customer)
select a.username, a.password, u.fullname, u.Addres , u.email, u.phone
from account a
inner join users u on a.username = u.username 
where u.category = 'user'
go

--fetch infor sellers
select a.username, a.password, u.fullname, u.Addres , u.email, u.phone,u.time_create, s.ID_Card
from account a
inner join users u on a.username = u.username
inner join seller s on u.username = s.username
go

--check login and fetch fullname
select a.username, a.password , u.fullname
from account a
inner join users u on a.username =  u.username
where a.username = 'accountSeller'
go

truncate table product
go

DELETE FROM account WHERE username like 'dung%';

--take infor tables
select * from account
go

select * from users
go

select * from seller
go

--if account added and
--infor insert in users is wrong will delete account that
DELETE FROM account WHERE username = 'neverDie';

DELETE FROM users WHERE username = 'neverDie';
DELETE FROM seller WHERE username = 'neverDie';
DELETE FROM avatar WHERE username = 'neverDie';
select u.fullname, u.Addres , u.phone, u.email, a.name_image
from users u
inner join avatar a on u.username = a.username
where u.username = 'dung5621'

--create product
create table product(
	ID_product int not null identity(1,1),
	name nvarchar(200) not null,
	price int not null,
	describe nvarchar(max) not null,
	nameImgOrVideo nchar(100),
	ID_seller int not null,
	primary key (ID_product),
	FOREIGN KEY (ID_seller) REFERENCES dbo.seller(ID_Seller)
)
go

--fetch id seller by username
select ID_Seller
from seller 
where username = 'accountSeller'
go

--insert product 
insert into product values(N'',300000,N'','',2)
go

-- fetch infor product
select * from product
where ID_seller = 2 and ID_product = 2
go
	
--fetch id biggest 
select  max(ID_product) maxID
from product


--fetch all information of seller by one product
select u.fullname , u.phone , u.email , u.Addres , s.ID_Card
from product p
inner join seller s on p.ID_seller = s.ID_Seller
inner join users u on s.username = u.username
where p.ID_product = 1
go

--random product to display in page home  (27 product)
SELECT top(27) * FROM product
ORDER BY newid()


--fetch all product
select *from product
go

--show all product of seller 
select * from product
where ID_seller = 2
go

--remove product
DELETE FROM product WHERE ID_product = 1;

--fetch product by id
select * from product where ID_product = 1;















