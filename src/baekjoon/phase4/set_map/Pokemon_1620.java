package baekjoon.phase4.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//나는야 포켓몬 마스터 이다솜
//https://www.acmicpc.net/problem/1620
public class Pokemon_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);


    }
}

/**
 * 도감에 수록되어 있는 포켓몬의 개수 N
 * 내가 맞춰야 하는 문제의 개수 M
 * 1 <= N, M <= 100,000
 *
 * N개의 줄,
 * 포켓몬 이름의 최대 길이는 20, 최소 길이는 2
 *
 * M개의 줄
 * 문제가 알파벳으로만 들어오면 포켓몬 번호를 말해야 하고,
 * 숫자로만 들어오면, 포켓몬 번호에 해당하는 문자를 출력
 */

