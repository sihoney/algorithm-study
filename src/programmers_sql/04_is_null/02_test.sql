-- 이름이 있는 동물의 아이디
-- https://school.programmers.co.kr/learn/courses/30/lessons/59407

-- 이름이 있는 동물의 ID를 조회
-- ID는 오름차순 정렬

-- 문제
SELECT animal_id
from animal_ins
where name is not null
order by animal_id;