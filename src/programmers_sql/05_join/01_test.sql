-- 상품 별 오프라인 매출 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131533

-- PRODUCT, OFFLINE_SALE
-- 동일한 날짜, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재
-- 상품코드 별 매출액(판매가 * 판매량) 합계를 출력
-- 매출액을 기준으로 내림차순 정렬
-- 상품코드를 기준으로 오름차순 정렬

-- 해결
SELECT
    pd.product_code,
    sum(pd.price * os.sales_amount) as sales
from product pd
         join offline_sale os
              on pd.product_id = os.product_id
group by pd.product_code
order by sales desc, product_code;