package baekjoon.phase1.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최댓값
// https://www.acmicpc.net/problem/2562
public class MaxValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer max = 0;
        Integer idx = null;
        for(int i = 0; i < 9; i++) {
            Integer d = Integer.parseInt(br.readLine());

            if(d > max) {
                max = d;
                idx = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}
