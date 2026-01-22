package baekjoon.phase3.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분수찾기
// https://www.acmicpc.net/problem/1193
public class FractionFinder_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine()); // 1 ≤ X ≤ 10,000,000

        int max = 1;
        int level = 1;

        while(x > max) {
            max += level + 1;
            level++;
        }

        int sum = level + 1;
        int min = max - level + 1;
        int idx = x - min;

        int f_a = idx + 1;
        int f_b = sum - f_a;

        if(level % 2 == 0) System.out.println(f_a + "/" + f_b);
        else System.out.println(f_b + "/" + f_a);
    }
}

/**
 * f        x       level   sum         max     idx
 * ------------------------------------------------------------------
 * 1/1      1       1       2           1       0
 * ------------------------------------------------------------------
 * 1/2      2       2       3                   0
 * 2/1      3       2       3           3(+2)   1
 * ------------------------------------------------------------------
 * 3/1      4       3       4                   0
 * 2/2      5       3       4                   1
 * 1/3      6       3       4           6(+3)   2
 * ------------------------------------------------------------------
 * 1/4      7       4       5                   0
 * 2/3      8       4       5                   1
 * 3/2      9       4       5                   2
 * 4/1      10      4       5           10(+4)  3
 * ------------------------------------------------------------------
 */
