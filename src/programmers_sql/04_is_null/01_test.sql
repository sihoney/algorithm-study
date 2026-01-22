-- 문재
-- 이름이 없는 동물의 아이디
-- https://school.programmers.co.kr/learn/courses/30/lessons/59039

-- ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
-- 이름이 없는 채로 들어온 동물의 ID를 조회

-- 해결
SELECT animal_id
from animal_ins
where name is null
