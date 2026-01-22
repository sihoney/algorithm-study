-- 조건에 맞는 도서와 저자 리스트 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/144854

# BOOK, AUTHOR
# '경제' 카테고리
# 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력
# 출판일을 기준으로 오름차순 정렬
# PUBLISHED_DATE의 데이트 포맷이 예시와 동일, 2021-02-05

-- 해결
SELECT
    b.book_id,
    a.author_name,
    date_format(b.published_date, '%Y-%m-%d')
from book b
         inner join author a on b.author_id = a.author_id
where b.category = '경제'
order by b.published_date;