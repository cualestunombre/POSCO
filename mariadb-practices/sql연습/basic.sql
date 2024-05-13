select version(), current_date, now() from dual;
-- 날짜 관련
select sin(pi()/4);
-- 수학 함수도 된다

create table pet(
	name varchar(255) ,
    owner varchar(50) ,
    species varchar(20),
    gender char(1),
    birth date,
    death date
);
-- table 생성 : DDL

desc pet;
-- schema 확인

insert into pet  (name,owner,species,gender) values("asd","sdf","멍멍","f");

update pet set species="ddf" where name ="asd";

select * from pet;

delete from pet where name = "asd";

select * from pet;

drop table pet;
-- 테이블 삭제



-- load data local infile '/root/pet/txt' into table pet; mysql cli 전용
-- load data 



select name, species
from pet
where name = 'bowser';
-- select 연습

select * 
from pet
order by birth;
-- order by 연습