package baekjoon.phase5.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//팩토리얼
//https://www.acmicpc.net/problem/10872
public class Factorial_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }

    static int factorial(int n) {
        if(n == 0) return 1;

        return n * factorial(n - 1);
    }
}

/**
 * N!을 출력
 *  N(0 ≤ N ≤ 12)
 */