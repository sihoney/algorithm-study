package baekjoon.phase3.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수
// https://www.acmicpc.net/problem/2581
public class PrimeRange_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int minPrime = Integer.MAX_VALUE;

        for(int i = m; i <= n; i++) {
            if(isPrime(i)) {
                sum += i;
                if(i < minPrime) minPrime = i;
            }
        }

        if(sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(minPrime);
        }
    }

    static boolean isPrime(int v) {
        if(v == 1) return false;

        for(int i = 2; i <= Math.sqrt(v); i++) { // 2 ~ 루트 v
            if(v % i == 0) return false;
        }

        return true;
    }
}
