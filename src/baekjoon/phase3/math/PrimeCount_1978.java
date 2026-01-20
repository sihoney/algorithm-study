package baekjoon.phase3.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 찾기
// https://www.acmicpc.net/problem/1978
public class PrimeCount_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        while(st.hasMoreTokens()) {
            if(isPrime(Integer.parseInt(st.nextToken()))) count++;
        }

        System.out.println(count);
    }

    static boolean isPrime(int v) {
        if(v == 1) return false;

        for(int i = 2; i <= Math.sqrt(v); i++) { // 2 ~ 루트 v
            if(v % i == 0) return false;
        }

        return true;
    }
}

/**
 * prime
 * 1보다 큰 자연수 중 1과 자기 자신만을 약수로 갖는 수
 * 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 등
 */
