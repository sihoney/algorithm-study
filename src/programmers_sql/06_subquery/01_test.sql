-- 문제
-- 식품분류별 가장 비싼 식품의 정보 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131116

# FOOD_PRODUCT
# PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
# 식품분류별, 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회
# 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력
# 식품 가격을 기준으로 내림차순 정렬

-- 해결
select
    fp.category,
    t.max_price,
    fp.product_name
from food_product fp
     join (
        select
            category,
            max(price) as max_price
        from food_product
        where category in ('과자', '국', '김치', '식용유')
        group by category
     ) t on fp.price = t.max_price and fp.category = t.category
order by fp.price desc

-- 어려웠던 점
-- join on절에서 조건을 두 개 주어야 했다! (price, category)
