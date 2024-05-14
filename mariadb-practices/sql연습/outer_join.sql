use webdb;

-- insert into dept values(null,'총무');
-- insert into dept values(null,'개발');
-- insert into dept values(null,'영업');
-- insert into dept values(null,'기획');

select * from dept;

-- insert into emp values(null,'둘리',1);
-- insert into emp values(null,'마이콜',1);
-- insert into emp values(null,'또치',1);
-- insert into emp values(null,'길동', null);

select * from emp;

select * 
from emp a
inner join dept b
on a.dept_no = b.no;
-- inner join

select a.name as '이름', ifnull(b.name,'없음') as '부서'
from emp a
left outer join dept b
on a.dept_no = b.no;
-- outer join


