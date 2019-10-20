create table zhangwu (
zwid INT PRIMARY KEY AUTO_INCREMENT,
flname VARCHAR(200),
money DOUBLE,
zhanghu VARCHAR(100),
createtime DATE,
description VARCHAR(1000)
);

insert into zhangwu values(1,'A',1000,'支付','2012-08-11','工资'),(2,'B',2000,'收入','2013-08-11','油水')
,(3,'C',3000,'收入','2015-08-11','油水'),(4,'D',4000,'支付','2016-08-11','支付'),
(5,'E',5000,'收入','2017-08-11','油水');