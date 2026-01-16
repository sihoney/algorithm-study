package baekjoon.phase2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단어의 개수
// https://www.acmicpc.net/problem/1152
public class WordCount_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(st.countTokens());
    }
}
/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  └─ st (reference)
 *
 * Heap:
 * String (입력 줄)
 * StringTokenizer
 *
 * 2. 시간 복잡도
 * 토큰 파싱: O(n)
 * countTokens(): 내부적으로 토큰 수 계산
 *
 * [이 문제의 진짜 교훈]
 * 문자열 문제는
 * “직접 쪼개기 전에, 도구가 이미 해결해주는지”를 먼저 봐야 한다.
 *
 * - 직접 구현 ❌
 * - 상태 관리 ❌
 * - 조건 분기 ❌
 * → 라이브러리의 의미를 정확히 이해하고 사용
 */
