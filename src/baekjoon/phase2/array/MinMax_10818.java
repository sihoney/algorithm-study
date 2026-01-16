package baekjoon.phase2.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소, 최대
// https://www.acmicpc.net/problem/10818
public class MinMax_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = -1000000;
        int min = 1000000;
        while(st.hasMoreTokens()){
            int v = Integer.parseInt(st.nextToken());

            if(v > max) max = v;
            if(v < min) min = v;
        }

        System.out.println(min + " " + max);
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ N
 *  ├─ max
 *  ├─ min
 *  ├─ v
 *  └─ st (reference)
 *
 * Heap:
 * String (입력 라인)
 * StringTokenizer
 *
 * ❗ 배열이 없다
 * → Heap 점유가 입력 크기와 무관
 * → GC 부담 거의 없음
 *
 * 2. 시간 복잡도
 * 토큰 순회: O(N)
 * 총합: O(N)
 *
 * 하지만 중요한 건:
 * 상수 계수가 매우 작다
 * - 비교 2번
 * - 분기 2번
 * - 객체 생성 없음
 */
