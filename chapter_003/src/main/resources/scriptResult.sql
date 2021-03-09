select *
from students;

select name, course
from students;

select *
from students
where course = 2;

select *
from students
where course != 2;

select *
from students
where name is null;

select *
from students
where name is not null;

select *
from students
where enroll_date > '2016-09-01';

select *
from students
where course > 2;

select *
from students
where name like 'A%';

select *
from students
where name like '%B';

select *
from students
where name like '%AC%';

select *
from students
where name like 'A%'
  and course = 3;

select *
from students
where name like '%B'
   or course < 5;

select current_date;

select current_date > '2020-03-05';

select current_date + interval '1 year';

select *
from students
order by name desc;

select *
from students
order by enroll_date asc;

select distinct course
from students;

select *
from students limit 5;

select *
from students limit 5
offset 5;
