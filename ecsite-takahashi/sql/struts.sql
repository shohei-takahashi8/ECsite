set names utf8;
set foreign_key_checks = 0;

drop database if exists ecsite_takahashi;
create database ecsite_takahashi;
use ecsite_takahashi;


create table user_info(
id int  not null primary key auto_increment,
user_id varchar(16) not null unique,
password varchar(16) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
sex tinyint default 0,
email varchar(32),
status tinyint default 0,
logined tinyint not null default 0,
regist_date datetime not null,
update_date datetime
);