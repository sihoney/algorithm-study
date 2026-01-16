package baekjoon.phase2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자의 합
// https://www.acmicpc.net/problem/11720
public class DigitSum_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        int sum = 0;
        for(char c : arr) {
            sum += c - '0';
        }

        System.out.println(sum);
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ n
 *  ├─ sum
 *  └─ c (loop variable)
 *
 * Heap:
 * String (입력 줄)
 * char[] arr
 *
 * 2. 시간 복잡도
 * 문자 순회: O(n)
 * 총합: O(n)
 *
 */