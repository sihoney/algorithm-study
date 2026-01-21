-- 문제
-- 가격이 제일 비싼 식품의 정보 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131115

-- 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 조회

-- 해결
SELECT
    product_id,
    product_name,
    product_cd,
    category,
    price
from food_product
order by price desc
    limit 1;

-- 개선안
-- 동일한 최고가 식품이 여러 개라면?
-- 현재 쿼리는 가장 먼저 정렬된 1개만 반환한다.
-- 👉 동일 최고가 식품을 모두 조회해야 한다면, 서브쿼리를 사용해야 한다.
SELECT
    product_id,
    product_name,
    product_cd,
    category,
    price
FROM food_product
WHERE price = (
    SELECT MAX(price)
    FROM food_product
);
