-- 고양이와 개는 몇 마리 있을까
-- https://school.programmers.co.kr/learn/courses/30/lessons/59040

-- 고양이와 개가 각각 몇 마리인지 조회
-- 고양이를 개보다 먼저 조회

-- 해결
select
    animal_type,
    count(*)
from animal_ins
group by animal_type
order by animal_type;

