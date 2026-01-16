package baekjoon.phase2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자열 반복
// https://www.acmicpc.net/problem/2675
public class Repeat_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()); // 3
            char[] s = st.nextToken().toCharArray(); // abc

            for (char c : s) {
                for (int j = 0; j < r; j++) {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

/**
 * [문제의 핵심 구조]
 * > 각 문자 → r번 반복 → 순서 유지
 *
 * 메모리 구조 해부
 * Stack:
 * main()
 *  ├─ T
 *  ├─ r
 *  ├─ i, j
 *  └─ c
 *
 * Heap:
 * StringBuilder sb
 * StringTokenizer
 * char[] s
 *
 * [시간 복잡도]
 * 문자열 길이 = L
 * 반복 횟수 = r
 *
 * 총 연산 = O(L × r)
 *
 *
 */