package baekjoon.phase1.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 최소, 최대
// https://www.acmicpc.net/problem/10818
public class MinMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");

        Integer max = -1000000;
        Integer min = 1000000;

        for(int i = 0; i < N; i++) {
            Integer d = Integer.parseInt(arr[i]);

            if(d > max) max = d;
            if(d < min) min = d;
        }

        System.out.println(min + " " + max);
    }
}
