-- 문제
-- 카테고리 별 도서 판매량 집계하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/144855

# 도서 정보(BOOK), 판매 정보(BOOK_SALES)
# 2022년 1월의 카테고리 별 도서 판매량을 합산,
# 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
# 카테고리명을 기준으로 오름차순 정렬

-- 해결
SELECT
    b.category,
    sum(bs.sales)
from book b
    join book_sales bs on b.book_id = bs.book_id
where sales_date between '2022-01-01' and '2022-01-31'
group by b.category
order by b.category
