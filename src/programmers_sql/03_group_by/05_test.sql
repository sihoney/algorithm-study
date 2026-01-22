-- 문제
-- 성분으로 구분한 아이스크림 총 주문량
-- https://school.programmers.co.kr/learn/courses/30/lessons/133026

-- first_half, icecream_info
-- 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량
-- 총주문량이 작은 순서대로 조회
-- 총주문량을 나타내는 컬럼명은 TOTAL_ORDER로 지정해

-- 해결
SELECT
    ii.ingredient_type,
    sum(fh.total_order) as TOTAL_ORDER
from first_half fh
         join icecream_info ii on fh.flavor = ii.flavor
group by ii.ingredient_type
order by total_order;
