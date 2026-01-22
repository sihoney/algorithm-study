-- 문제
-- 있었는데요 없었습니다
-- https://school.programmers.co.kr/learn/courses/30/lessons/59043

-- ANIMAL_INS, ANIMAL_OUTS
# 보호 시작일보다 입양일이 더 빠른 동물
# 아이디와 이름을 조회
# 보호 시작일이 빠른 순으로 조회

-- 해결
SELECT
    ai.animal_id,
    ai.name
from animal_outs ao
         inner join animal_ins ai
                    on ao.animal_id = ai.animal_id
where ai.datetime > ao.datetime
order by ai.datetime;