-- 문제
-- 최댓값 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59415

-- 가장 최근에 들어온 동물은 언제 들어왔는지 조회

-- 해결
SELECT datetime
from animal_ins
where datetime = (
    select max(datetime)
    from animal_ins
);