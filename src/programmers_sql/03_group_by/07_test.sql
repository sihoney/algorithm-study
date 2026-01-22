## 문제
-- 즐겨찾기가 가장 많은 식당 정보 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131123

-- 음식종류별
-- 즐겨찾기수가 가장 많은 식당
-- 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회
-- 음식 종류를 기준으로 내림차순 정렬

## 해결
select
    food_type,
    rest_id,
    rest_name,
    favorites
from (
    SELECT
        *,
        row_number() over (
            partition by food_type
            order by favorites desc
        ) as rn
    from rest_info
    ) t
where rn = 1
order by food_type desc;

## 오답
SELECT
    food_type,
    rest_id,
    rest_name,
    max(favorites)
from rest_info
group by food_type
order by food_type desc;
