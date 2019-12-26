# 安卓作业My12306的服务端   
Mysql+TkMybatis+SpringBoot   
实现用户登录注册及用户信息修改   

数据表:   
```mysql
create table if not exists user
(
	username varchar(20) not null,
	password varchar(20) not null,
	name varchar(15) null,
	id_card_type varchar(15) null,
	id_card_number varchar(20) null,
	user_type varchar(15) null,
	phone_number varchar(12) null,
	constraint user_username_uindex
		unique (username)
);

alter table user
	add primary key (username);
```