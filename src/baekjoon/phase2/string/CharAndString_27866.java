package baekjoon.phase2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자와 문자열
// https://www.acmicpc.net/problem/27866
public class CharAndString_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());

        System.out.println(s.charAt(i - 1));
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ s (reference)
 *  └─ i
 *
 * Heap:
 * String 객체
 *  └─ char[] value
 *
 * 2. 시간 복잡도
 * charAt: O(1)
 * 전체: O(1)
 */