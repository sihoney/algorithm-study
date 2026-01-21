-- 문제
-- 진료과별 총 예약 횟수 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/132202

-- 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회
-- 컬럼명은 '진료과 코드', '5월예약건수'로 지정
-- 환자 수를 기준으로 오름차순 정렬
-- 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬

-- 해결
SELECT
    mcdp_cd as '진료과코드',
    count(*) as '5월예약건수'
from appointment
where apnt_ymd like '2022-05%'
group by mcdp_cd
order by count(*), mcdp_cd;a

-- ❓ 왜 ORDER BY에서 alias를 쓰면 오답이 될까?
-- ORDER BY '5월예약건수'
-- 이건 컬럼 alias를 가리키는 게 아니라,
-- 👉 문자열 상수 '5월예약건수' 로 인식됨