package baekjoon.phase2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알파벳 찾기
// https://www.acmicpc.net/problem/10809
public class Alphabet_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray() ;

        int[] loca = new int[26];

        for(int i = 0; i < s.length; i++) {
            int alpha_idx = s[i] - 97;
            if(loca[alpha_idx] == 0) loca[alpha_idx] = i + 1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < loca.length; i++) {
            if(loca[i] == 0) sb.append("-1");
            else sb.append(loca[i] - 1);

            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ i
 *  ├─ alpha_idx
 *  └─ sb
 *
 * Heap:
 * char[] s        // 입력 문자열
 * int[26] loca    // 알파벳 상태 배열
 * StringBuilder
 *
 * 2. 시간 복잡도
 * 문자열 순회: O(n)
 * 알파벳 출력: O(26)
 * 총합: O(n)
 */
