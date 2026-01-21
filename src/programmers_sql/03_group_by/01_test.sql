-- 문제
-- 동명 동물 수 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59041

# 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수
# 이름이 없는 동물은 집계에서 제외
# 결과는 이름 순으로 조회

-- 해결
SELECT
    name,
    count(name) as count
FROM animal_ins
where name is not null
group by name
having count(name) >= 2
order by name asc;