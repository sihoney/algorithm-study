-- 문제
-- 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/151137

-- '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함
-- 자동차 종류 별로 몇 대인지 출력
-- 자동차 수에 대한 컬럼명은 CARS
-- 자동차 종류를 기준으로 오름차순 정렬

-- 해결
SELECT
    car_type,
    count(*) as CARS
from car_rental_company_car
where options like '%통풍시트%'
   or options like '%열선시트%'
   or options like '%가죽시트%'
group by car_type
ORDER BY car_type;