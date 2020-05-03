use imooc;
-- create table test_primary_key(
--     id int unsigned primary key,
--     username varchar(20)
-- );
-- select * from test_primary_key；
-- desc test_primary_key;
-- insert test_primary_key(id, username)
-- values(1,"king");
-- select * from test_primary_key;

-- create table test_primary_key1(
--     id int unsigned,
--     courseId int unsigned,
--     username varchar(20),
--     email varchar(50),
--     primary key(id, courseId)
-- );
-- desc test_primary_key1;

-- create table test_primary_key2(
--     id int unsigned key auto_increment,
--     courseId int unsigned
-- );
-- desc test_primary_key2;
-- insert test_primary_key2(courseId) values(123);
-- insert test_primary_key2(courseId) values(456);
-- insert test_primary_key2(courseId) values(789);
select * from test_primary_key2;