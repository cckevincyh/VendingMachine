create database VendingMachineDB;

DROP database VendingMachineDB;


create table Administrator(
       username varchar(30) primary key,
       passwords varchar(30) not null
);



create table Drink(
       drinkId varchar(20) primary key, 
       drinkName varchar(30) not null, 
       drinkImg varchar(40) not null, 
       price int not null, 
       quantity int not null DEFAULT 0
);



create table VendingMachine(
       id int  primary key, #编号
       totalAmount int not null,  #总金额
       coin int not null #零钱金额
);


create table PurchaseRecords(
       customerId int auto_increment primary key, #顾客编号
       drinkName varchar(30) not null, #饮料名字
       price int not null, #价格
       payment int not null, #支付金额
       repayment int not null, #找回金额
       buyTime datetime not null #购买时间
     
);

create table CashRecords(
       id int auto_increment primary key, #编号
       administrator  varchar(30) not null, #操作管理员
       beforeCash int not null, #取现前的金额
       cash int not null, #取现金额
       afterCash int not null, #取现后的金额
       CashTime datetime not null  #取现的时间
      
);


create table AddRecords(
        id int auto_increment primary key, #编号
        administrator  varchar(30) not null,   #操作管理员
        beforeAdd int not null, #补充前的金额
        addAmount int not null, #补充金额
        afterAdd int not null, #补充后的金额
        add_Time datetime not null #补充的时间
       
);



create table addDrinkRecords(
       id int auto_increment primary key,  #编号
       administrator  varchar(30) not null, #操作管理员
        drinkName varchar(30) not null, #饮料名字
        add_Time datetime not null, #添加时间
        before_num int not null, #添加前的数量
        add_num int not null, #添加的数量
        now_num int not null #添加后的数量
       
)


select * from Administrator;
insert into administrator values('admin','admin');
drop table drink;
insert into Drink(drinkId,drinkName,drinkImg,price,quantity) values ('01','百事可乐','img/baishi.png',2,50);
insert into Drink(drinkId,drinkName,drinkImg,price,quantity) values ('02','芬达','img/fenda.png',2,50);
insert into Drink(drinkId,drinkName,drinkImg,price,quantity) values ('03','雪碧','img/xuebi.png',2,50);
insert into Drink(drinkId,drinkName,drinkImg,price,quantity) values ('04','可口可乐','img/kekokele.png',2,50);
insert into Drink(drinkId,drinkName,drinkImg,price,quantity) values ('05','鲜橙多','img/chenzhida.png',2,50);
select * from Drink;
