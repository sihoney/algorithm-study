package baekjoon.phase2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열
// https://www.acmicpc.net/problem/9086
public class String_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            String str = br.readLine();

            sb.append(str.charAt(0))
                .append(str.charAt(str.length() - 1))
                .append("\n");
        }

        System.out.println(sb.toString());
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ T
 *  ├─ i
 *  ├─ str (reference)
 *  └─ sb (reference)
 *
 * Heap:
 * StringBuilder
 * String (각 줄 입력)
 *  └─ 내부 char[]
 *
 * 2. 시간 복잡도
 * 각 테스트 케이스마다:
 *
 * - charAt(0) → O(1)
 * - length() → O(1)
 * - charAt(length - 1) → O(1)
 *
 * 전체:
 * O(T)
 * => 문자열 길이와 무관하다.
 */
