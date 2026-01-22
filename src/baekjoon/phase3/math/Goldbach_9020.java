package baekjoon.phase3.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드바흐의 추측
// https://www.acmicpc.net/problem/9020
public class Goldbach_9020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        int[] arr = new int[T];
        int max = 0;

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 4 ≤ n(짝수) ≤ 10,000

            arr[i] = n;

            if(n > max) max = n;
        }

        boolean[] isPrime = makePrimeTable(max);

        for(int i = 0; i < T; i++) {
            int n = arr[i];
            int a = n / 2;
            int b = n / 2;

            while (a > 1) {
                if (isPrime[a] && isPrime[b]) {
                    sb.append(a).append(" ").append(b).append("\n");
                    break;
                }
                a--;
                b++;
            }

        }

        System.out.println(sb.toString());
    }

    static boolean[] makePrimeTable(int max) {
        boolean[] isPrime = new boolean[max + 1];

        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

//        for (int j = 2 * i; j <= max; j += i)
//        --> 이건 틀리진 않다, 하지만 쓸데없는 일을 많이 한다.
//        이전 반복에서 처리됨
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    public static void main_wrong(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 4 ≤ n(짝수) ≤ 10,000

            int first_partition = n / 2;
            int second_partition = n / 2;

            while(first_partition > 1) {
                if(isPrime(first_partition) && isPrime(second_partition)) {
                    break;
                }

                first_partition--;
                second_partition++;
            }

            sb.append(first_partition)
                    .append(" ")
                    .append(second_partition)
                    .append("\n");
        }

        System.out.println(sb.toString());
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
 * 소수:
 * 1과 자기 자신을 제외한 약수가 없는 자연수
 *
 * 골드바흐의 추측:
 * 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.
 * 이러한 수를 골드바흐 수라고 한다.
 *
 * 골드바흐 파티션:
 * 짝수를 두 소수의 합으로 나타내는 표현
 *
 *
 */