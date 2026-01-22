-- 문제
-- 없어진 기록 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59042

# 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물
# 동물의 ID와 이름
# ID 순으로 조회

-- 해결
SELECT
    ao.animal_id,
    ao.name
from animal_ins ai
         right join animal_outs ao on ai.animal_id = ao.animal_id
where intake_condition is null
order by ao.animal_id
