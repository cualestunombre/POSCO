-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(*) as '평균 연봉보다 많은 월급 직원수'
from employees e
inner join salaries s on e.emp_no = s.emp_no and s.to_date >= now()
where s.salary >
	(
		select avg(s2.salary)
        from employees e2
        inner join salaries s2 on e2.emp_no = s2.emp_no and s2.to_date >= now()
	);


-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
select e.emp_no '사번', concat(e.first_name,' ',e.last_name) '이름', d.dept_name '부서명', s.salary '연봉'
from employees e
inner join dept_emp de on e.emp_no = de.emp_no and de.to_date >= now()
inner join departments d on d.dept_no = de.dept_no
inner join salaries s on s.emp_no = e.emp_no and s.to_date >= now()
where (d.dept_no, s.salary) in
	(
		select d2.dept_no,max(s2.salary)
		from employees e2
		inner join dept_emp de2 on e2.emp_no = de2.emp_no and de2.to_date >= now()
		inner join departments d2 on d2.dept_no = de2.dept_no
		inner join salaries s2 on s2.emp_no = e2.emp_no and s2.to_date >= now()
        group by d2.dept_no 
    )
order by s.salary desc
;


-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
select e.emp_no '사번', concat(e.first_name,' ',e.last_name) '이름', d.dept_name '부서명', s.salary '연봉'
from employees e
inner join dept_emp de on e.emp_no = de.emp_no and de.to_date >= now()
inner join departments d on d.dept_no = de.dept_no
inner join salaries s on s.emp_no = e.emp_no and s.to_date >= now()
inner join (
	select d2.dept_name dept_name, avg(s2.salary) salary
    from employees e2
	inner join dept_emp de2 on e2.emp_no = de2.emp_no and de2.to_date >= now()
	inner join departments d2 on d2.dept_no = de2.dept_no
	inner join salaries s2 on s2.emp_no = e2.emp_no and s2.to_date >= now()
    group by d2.dept_name
) nt on nt.dept_name = d.dept_name and s.salary > nt.salary; 

-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select e.emp_no '사번', concat(e.first_name,' ',e.last_name) '이름', d.dept_name '부서명', (select 
	concat(e2.first_name,' ',e2.last_name)
    from dept_manager dm2
    inner join employees e2 on dm2.emp_no = e2.emp_no and dm2.to_date >= now()
    where dm2.dept_no = d.dept_no
) '매니저 이름'
from employees e
inner join dept_emp de on e.emp_no = de.emp_no and de.to_date >= now()
inner join departments d on d.dept_no = de.dept_no;



-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
select e.emp_no '사번', concat(e.first_name,' ',e.last_name) '이름', t.title '직책', s.salary '연봉'
from employees e
inner join dept_emp de on e.emp_no = de.emp_no and de.to_date >= now()
inner join departments d on d.dept_no = de.dept_no
inner join salaries s on s.emp_no = e.emp_no and s.to_date >= now()
inner join titles t on s.emp_no = t.emp_no and t.to_date >= now()
inner join (
	select d2.dept_name dept_name, avg(s2.salary) salary
    from employees e2
	inner join dept_emp de2 on e2.emp_no = de2.emp_no and de2.to_date >= now()
	inner join departments d2 on d2.dept_no = de2.dept_no
	inner join salaries s2 on s2.emp_no = e2.emp_no and s2.to_date >= now()
    group by salary desc limit 1
) nt on nt.dept_name = d.dept_name;


-- 문제6.
-- 평균 연봉이 가장 높은 부서는? 
select d2.dept_name dept_name, avg(s2.salary) salary
    from employees e2
	inner join dept_emp de2 on e2.emp_no = de2.emp_no and de2.to_date >= now()
	inner join departments d2 on d2.dept_no = de2.dept_no
	inner join salaries s2 on s2.emp_no = e2.emp_no and s2.to_date >= now()
    group by salary desc limit 1;
-- 문제7.
-- 평균 연봉이 가장 높은 직책?
select t2.title , avg(s2.salary) salary
from employees e2
inner join salaries s2 on s2.emp_no = e2.emp_no and s2.to_date >= now()
inner join titles t2 on s2.emp_no = t2.emp_no and t2.to_date >= now()
group by t2.title desc limit 1;

-- 문제8.
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
select  d.dept_name '부서명', concat(e.first_name,' ',e.last_name) '사원이름', s.salary '연봉', concat(nt.name) as '매니저 이름',nt.salary as '매니저 연봉'
from employees e
inner join dept_emp de on e.emp_no = de.emp_no and de.to_date >= now()
inner join departments d on d.dept_no = de.dept_no
inner join salaries s on e.emp_no = s.emp_no and s.to_date >= now()
inner join (
	select dm2.dept_no, concat(e2.first_name, ' ', e2.last_name) as 'name', s2.salary
    from employees e2
    inner join dept_manager dm2 on e2.emp_no = dm2.emp_no and dm2.to_date >= now()
    inner join salaries s2 on s2.emp_no = dm2.emp_no and s2.to_date >= now()
) nt on nt.dept_no = d.dept_no and s.salary > nt.salary;

