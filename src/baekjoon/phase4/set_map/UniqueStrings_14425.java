package baekjoon.phase4.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//문자열 집합
//https://www.acmicpc.net/problem/14425
public class UniqueStrings_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        HashSet<String> s = new HashSet<>();

        for(int i = 0; i < N; i++) {
            s.add(br.readLine());
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            if(s.contains(br.readLine())) count++;
        }

        System.out.println(count);
    }
}

/**
 * N개의 문자열로 이루어진 집합 S
 * 입력으로 주어지는 M개의 문자열 중, 집합 S에 포함되어 있는 것이 총 몇 개인지
 * M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력
 */
