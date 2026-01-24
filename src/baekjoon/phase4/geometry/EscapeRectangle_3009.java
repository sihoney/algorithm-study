package baekjoon.phase4.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//네 번째 점
//https://www.acmicpc.net/problem/3009
public class EscapeRectangle_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] comb = new int[2][3];

        for(int r = 0; r < 3; r++) {
            String[] line = br.readLine().split(" ");

            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);


        }
    }
}

/**
 * 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점
 * x    y
 * a    c
 * b    d
 *
 * a, c
 * a, d
 * b, c
 * b, d
 */
