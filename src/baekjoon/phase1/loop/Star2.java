package baekjoon.phase1.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

// 별 찍기 - 2
// https://www.acmicpc.net/problem/2439
public class Star2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        StringBuffer txt = new StringBuffer();
        StringBuffer star = new StringBuffer("*");
        StringBuffer b = new StringBuffer();

        for(int j = 0; j < N - 1; j++) {
            b.append(" ");
        }

        for(int i = 0; i < N; i++) {
            txt.append(b);
            txt.append(star);
            txt.append("\n");

            star.append("*");
            b.delete(0, 1);
        }

        System.out.println(txt.toString());
    }
}
