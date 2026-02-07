-- 570. Managers with at Least 5 Direct Reports

select
    m.name
from employee e
         left join employee m
                   on e.managerId = m.id
group by m.id, m.name
having count(m.id) >= 5