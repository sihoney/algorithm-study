package baekjoon.phase1.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//A+B - 7
//https://www.acmicpc.net/problem/11021
public class AplusB7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            String[] arr = br.readLine().split(" ");
            Integer a = Integer.parseInt(arr[0]);
            Integer b = Integer.parseInt(arr[1]);

            String format = String.format("Case #%d: %d", i, a + b);
            System.out.println(format);
        }
    }
}
