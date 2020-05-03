create database if not exists imooc;
use imooc;
-- 用户表 user
create table if not exists user(
id int,
username varchar(20),
password char(32),
email varchar(50),
age tinyint,
card char(18),
tel char(11),
salary float(8,2),
married tinyint(1),
addr varchar(100), 
sex enum("男","女","保密") 
)engine=innodb charset=utf8;

CREATE TABLE test_float(
    a FLOAT(6,2),
    b DOUBLE(6,2),
    c DECIMAL(6,2)
);

INSERT test_float(a,b,c) VALUES(4.143, 4.146,4.149);

create table test_primary_key(
    id int unsigned primary key,
    username varchar(20)
);