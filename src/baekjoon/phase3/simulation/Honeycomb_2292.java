package baekjoon.phase3.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 벌집
// https://www.acmicpc.net/problem/2292
public class Honeycomb_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 1,000,000,000

        int level = 1;
        int max = 1;

        while(n > max){
            max += 6 * level;

            level++;
        }

        System.out.println(level);
    }

    public static void main_wrong(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 1,000,000,000

        int i = 1;
        int sum = 1;

        while(n > sum){
            sum += 6 * (i - 1);

            if(n < sum) {
                break;
            }

            i++;
        }

        System.out.println(i);
    }
}

/**
 *              level       count
 * 1            1           1
 * 2 ~ 7        2           6
 * 8 ~ 19       3           12
 * 20 ~ 37      4           18
 * 38 ~ 61      5           24
 *
 */
