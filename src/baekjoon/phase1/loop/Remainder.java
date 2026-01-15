package baekjoon.phase1.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 나머지
// https://www.acmicpc.net/problem/3052
public class Remainder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < 10; i++) {
            Integer t = Integer.parseInt(br.readLine());

            set.add(t % 42);
        }

        System.out.println(set.size());
    }
}
