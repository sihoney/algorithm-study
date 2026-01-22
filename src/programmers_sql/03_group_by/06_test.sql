-- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/157340

# 2022년 10월 16일에 대여 중인 자동차인 경우, '대여중' 이라고 표시
# 대여 중이지 않은 자동차인 경우, '대여 가능'을 표시
# 컬럼(컬럼명: AVAILABILITY)을 추가
# 자동차 ID와 AVAILABILITY 리스트를 출력
# 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'으로 표시
# 자동차 ID를 기준으로 내림차순 정렬

-- 해결
SELECT car_id,
       case
           when max(case
                        when '2022-10-16' between start_date and end_date
                            then 1
                        else 0
               end) = 1
               then '대여중'
           else '대여 가능'
           end AVAILABILITY
from car_rental_company_rental_history
group by car_id
order by car_id desc;