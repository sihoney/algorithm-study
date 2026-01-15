package baekjoon.phase1.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 별 찍기 - 1
// https://www.acmicpc.net/problem/2438
public class Star1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        StringBuffer temp = new StringBuffer("*");
        for(int i = 0; i < N; i++) {
            sb.append(temp.toString() + "\n");

            temp.append("*");
        }

        System.out.println(sb.toString());
    }
}
