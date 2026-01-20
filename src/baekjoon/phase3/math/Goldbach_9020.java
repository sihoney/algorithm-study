package baekjoon.phase3.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드바흐의 추측
// https://www.acmicpc.net/problem/9020
public class Goldbach_9020 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine()); // 4 ≤ n(짝수) ≤ 10,000

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