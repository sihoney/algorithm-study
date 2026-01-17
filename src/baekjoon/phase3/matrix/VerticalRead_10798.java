package baekjoon.phase3.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 세로읽기
// https://www.acmicpc.net/problem/10798
public class VerticalRead_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] arr = new char[5][];
        int max_c = 0;

        for(int r = 0; r < 5; r++) {
            arr[r] = br.readLine().toCharArray();

            if(arr[r].length > max_c) max_c = arr[r].length;
        }

        int c = 0;
        while(c < max_c) {
            for(int r = 0; r < 5; r++) {
                if(c >= arr[r].length) continue;
                sb.append(arr[r][c]);
            }

            c++;
        }

        System.out.println(sb.toString());
    }
}

/**
 * 1. 문제 -> 구조 요약
 * 입력은 “행 기준”, 출력은 “열 기준”
 *
 * 2. 메모리 구조
 * Stack:
 * main()
 *  ├─ c, r
 *  └─ max_c
 *
 * Heap:
 * char[] arr[0]
 * char[] arr[1]
 * char[] arr[2]
 * char[] arr[3]
 * char[] arr[4]
 *
 * 3. 시간 복잡도
 * 행 입력: O(문자 수 총합)
 * 출력: O(5 × max_c)
 */
