-- 문제
-- 과일로 만든 아이스크림 고르기
-- https://school.programmers.co.kr/learn/courses/30/lessons/133025

-- first_half: 상반기 주문 정보
-- icecream_info: 아이스크림 성분 정보
-- 총주문량이 3,000보다 높
-- 아이스크림의 주 성분이 과일
-- 아이스크림의 맛 조회
-- 총주문량이 큰 순서대로 조회

-- 해결
SELECT f.flavor as FLAVOR
from first_half f
         left join icecream_info i on i.flavor = f.flavor
where i.ingredient_type = 'fruit_based'
  and f.total_order > 3000
order by f.total_order desc;

-- 개선안
SELECT f.flavor AS FLAVOR
FROM first_half f
         JOIN icecream_info i ON i.flavor = f.flavor
WHERE i.ingredient_type = 'fruit_based'
  AND f.total_order > 3000
ORDER BY f.total_order DESC;