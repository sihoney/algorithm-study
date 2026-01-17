package baekjoon.phase3.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최댓값
// https://www.acmicpc.net/problem/2566
public class MaxInMatrix_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

//        int[][] arr = new int[9][9];
        int max = Integer.MIN_VALUE;
        int max_r = 0;
        int max_c = 0;

        StringTokenizer st;
        for(int r = 0; r < 9; r++) {
            st = new StringTokenizer(br.readLine());

            for(int c = 0; c < 9; c++) {
                int v = Integer.parseInt(st.nextToken());

                if(v > max) {
                    max = v;
                    max_r = r;
                    max_c = c;
                }
            }
        }

        System.out.println(sb.append(max)
                .append("\n")
                .append(max_r + 1)
                .append(" ")
                .append(max_c+ 1));

    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ max
 *  ├─ max_r
 *  ├─ max_c
 *  ├─ r, c
 *  └─ v
 *
 * Heap:
 * BufferedReader 내부 버퍼
 * StringTokenizer
 *
 * 2. 시간 복잡도
 * 9 × 9 = 81회 비교
 * O(1)
 *
 */
