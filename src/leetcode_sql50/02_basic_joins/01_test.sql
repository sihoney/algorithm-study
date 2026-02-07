-- 1378. Replace Employee ID With The Unique Identifier

select
    u.unique_id
     , e.name
from employees e
left join employeeUNI u
    on e.id = u.id