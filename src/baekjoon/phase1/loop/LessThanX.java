package baekjoon.phase1.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// X보다 작은 수
// https://www.acmicpc.net/problem/10871
public class LessThanX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        Integer n = Integer.parseInt(split[0]);
        Integer x = Integer.parseInt(split[1]);

        String[] arr = br.readLine().split(" ");

        StringBuffer sb= new StringBuffer();
        for(int i = 0; i < n; i++) {
            Integer t = Integer.parseInt(arr[i]);

            if(t < x) {
                sb.append(t);
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
