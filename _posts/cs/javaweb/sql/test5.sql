create database jdbctest;
use jdbctest;
create table [user](
    uid int key auto_increment,
    username varchar(20),
    password varchar(20),
    name varchar(20)
);
insert into user values(null, "aaa", "111", "tom");
insert into user values(null, "bbb", "222", "harry");
insert into user values(null, "ccc", "333", "cat");