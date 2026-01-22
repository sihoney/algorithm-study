-- 오랜 기간 보호한 동물(1)
-- https://school.programmers.co.kr/learn/courses/30/lessons/59044

# 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리 (where)
# 이름과 보호 시작일을 조회 (select)
# 보호 시작일 순으로 조회 (order by)

-- 해결
SELECT
    ai.name,
    ai.datetime
from animal_ins ai
         left join animal_outs ao on ai.animal_id = ao.animal_id
where ao.datetime is null
order by ai.datetime asc
    limit 3;
