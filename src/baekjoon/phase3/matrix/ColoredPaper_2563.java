package baekjoon.phase3.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
// https://www.acmicpc.net/problem/2563
public class ColoredPaper_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] bg = new boolean[100][100];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int z = x; z < x + 10; z++) {
                for(int j = y; j < y + 10; j++) {
                    bg[z][j] = true;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(bg[i][j]) sum += 1;
            }
        }

        System.out.println(sum);
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ n
 *  ├─ x, y
 *  ├─ z, j
 *  └─ sum
 *
 * Heap:
 * boolean[100][100] bg
 *
 * 2. 시간 복잡도
 * 색종이 덮기: n × 10 × 10 = O(n)
 * 전체 스캔: 100 × 100 = O(1)
 *
 */
