package baekjoon.phase1.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 평균
// https://www.acmicpc.net/problem/1546
public class Average {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int M = Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();

        double avg = Arrays.stream(arr)
                .mapToDouble(Double::parseDouble)
                .map(v -> v / M * 100)
                .average()
                .getAsDouble();

        System.out.println(avg);
    }
}
