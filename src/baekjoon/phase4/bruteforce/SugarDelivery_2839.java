package baekjoon.phase4.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 배달
// https://www.acmicpc.net/problem/2839
public class SugarDelivery_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N킬로그램
        int bag = -1;

//        5로 나누어지니?
        if(N % 5 == 0) bag = N / 5;

//        5로 나누어지지 않음
        for(int i = N / 5; i >= 0; i--) { // 5kg 봉지 개수--
//            나머지가 3으로 나누어지는 경우
            if((N - (5 * i)) % 3 == 0) {
                bag = i; // 5kg 봉지 개수
                bag += (N - (5 * i)) / 3; // 3kg 봉지 개수
                break;
            }
        }

        System.out.println(bag);
    }
}

/**
 * 3킬로그램 봉지와 5킬로그램 봉지
 * 배달하는 봉지의 최소 개수를 출력
 * 정확하게 N킬로그램을 만들 수 없다면 -1을 출력
 *
 * 18   5*3 + 3*1   4
 * 4                -1
 * 6    3*2         2
 * 9    3*3         3
 * 11   5*1 + 3*2   3
 *
 * N = 11
 * bag = -1
 *
 * i    (N - (5 * i)) % 3 == 0
 * 2    false
 * 1    true
 */
