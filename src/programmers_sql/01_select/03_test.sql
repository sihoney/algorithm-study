-- 문제
-- 인기있는 아이스크림
-- https://school.programmers.co.kr/learn/courses/30/lessons/133024

-- 총주문량을 기준으로 내림차순 정렬
-- 주문량이 같다면 출하 번호를 기준으로 오름차순 정렬

-- 해결
SELECT flavor
from first_half
order by total_order desc, shipment_id asc;