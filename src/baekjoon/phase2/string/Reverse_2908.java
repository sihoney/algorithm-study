package baekjoon.phase2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 상수
// https://www.acmicpc.net/problem/2908
public class Reverse_2908 {
//        숫자로 변환 ❌
//        문자열 비교 (자릿수 동일 → 사전식 = 숫자 비교)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        StringBuilder sb1 = new StringBuilder(arr[0]).reverse();
        StringBuilder sb2 = new StringBuilder(arr[1]).reverse();

        System.out.println(
                sb1.toString().compareTo(sb2.toString()) > 0
                        ? sb1
                        : sb2
        );
    }

    public static void main_before(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int a = flip(arr[0]);
        int b = flip(arr[1]);

        System.out.println(a > b ? a : b);
    }

    static int flip(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        return Integer.parseInt(sb.toString());
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ a, b
 *  └─ flip() stack frame
 *      ├─ i
 *      └─ sb (reference)
 *
 * Heap:
 * String (입력)
 * char[] arr
 * StringBuilder
 *
 * 2. 시간 복잡도
 * flip: O(k)  (k = 자릿수, 최대 3)
 * 전체: O(1)
 */