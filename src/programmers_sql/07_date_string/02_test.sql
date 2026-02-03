-- 문제
-- DATETIME에서 DATE로 형 변환
-- https://school.programmers.co.kr/learn/courses/30/lessons/59414

# 아이디 순으로 조회
# 시각(시-분-초)을 제외한 날짜(년-월-일)만 보여주세요.

-- 해결
select
    animal_id,
    name,
    date_format(datetime, '%Y-%m-%d') as '날짜'
from animal_ins
order by animal_id