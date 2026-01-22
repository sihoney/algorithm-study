-- 주문량이 많은 아이스크림들 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/133027

# FIRST_HALF, JULY
# FIRST_HALF 테이블의 기본 키는 FLAVOR
# FIRST_HALF테이블의 SHIPMENT_ID는 JULY테이블의 SHIPMENT_ID의 외래 키

# 7월에는 ..., 같은 맛의 아이스크림이라도 다른 출하 번호를 갖게 됩니다. (join)
# 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값 큰 순서 (group, sum)
# 상위 3개의 맛을 조회 (order, limit)

-- 해결 (1)
select
    flavor
from (
         select * from first_half
         union all
         select * from july
     ) t
group by flavor
order by sum(total_order) desc
    limit 3;

-- 해결 (2)
select
    fh.flavor
from first_half fh
         join (
    select
        flavor,
        sum(total_order) as total_order
    from july
    group by flavor
) j on fh.flavor = j.flavor
order by (fh.total_order + j.total_order) desc
    limit 3;

-- 오답
SELECT
    j.flavor
        # sum(fh.total_order + j.total_order)
from first_half fh
    right join july j on fh.shipment_id = j.shipment_id
group by fh.flavor
order by sum(fh.total_order + j.total_order) desc
    limit 3