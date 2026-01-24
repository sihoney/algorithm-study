package baekjoon.phase4.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 블랙잭
// https://www.acmicpc.net/problem/2798
public class BlackJack_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]); // 카드의 개수
        int M = Integer.parseInt(arr[1]); // M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합

        String[] nums = br.readLine().split(" ");

        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int x = j + 1; x < nums.length; x++) {
                    int a =Integer.parseInt(nums[i]);
                    int b =Integer.parseInt(nums[j]);
                    int c =Integer.parseInt(nums[x]);

                    int sum = a + b + c;

                    if(sum <= M && sum > result) {
                        result = sum;
                    }
                }
            }
        }

        System.out.println(result);
    }
}

/**
 * 📌 **완전탐색 입문 문제**
 *
 * * 3중 반복
 * * “조건을 만족하는 최대값”
 * * 탐색 범위를 감으로 줄이지 않기
 *
 * 👉 **브루트포스의 정석**
 */
