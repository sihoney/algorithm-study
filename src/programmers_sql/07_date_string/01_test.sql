-- 문제
-- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/151138

# 대여 시작일이 2022년 9월에 속하는 대여 기록
# 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 표시하는 컬럼(컬럼명: RENT_TYPE)을 추가
# 대여 기록 ID를 기준으로 내림차순 정렬

-- 해결
SELECT
    history_id,
    car_id,
    date_format(start_date, '%Y-%m-%d') as start_date,
    date_format(end_date, '%Y-%m-%d') as end_date,
    case
        when datediff(end_date, start_date) >= 29
            then '장기 대여'
            else '단기 대여'
        end as RENT_TYPE
from car_rental_company_rental_history
where month(start_date) = 9
order by history_id desc