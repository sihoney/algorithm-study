package baekjoon.phase4.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 직사각형에서 탈출
// https://www.acmicpc.net/problem/1085
public class Rectangle_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        int w = Integer.parseInt(arr[2]);
        int h = Integer.parseInt(arr[3]);

        System.out.println(Math.min(Math.min(x, y), Math.min(w-x, h-y)));
    }
}

/**
 * 직사각형의 경계선까지 가는 거리의 최솟값
 *
 *
 */
