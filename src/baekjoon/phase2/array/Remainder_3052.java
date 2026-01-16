package baekjoon.phase2.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 나머지
// https://www.acmicpc.net/problem/3052
public class Remainder_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] seen = new boolean[42];

        for (int i = 0; i < 10; i++) {
            int v = Integer.parseInt(br.readLine());
            seen[v % 42] = true;
        }

        int count = 0;
        for (boolean b : seen) {
            if (b) count++;
        }

        System.out.println(count);
    }
    public static void main_before(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        for(int i = 0; i < 10; i++) {
            int v = Integer.parseInt(br.readLine());

            arr[i] = v % 42;
        }

        int count = 0;
        Loop1:
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] == arr[j]) {
                    continue Loop1;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ v
 *  ├─ count
 *  ├─ i, j
 *
 * Heap:
 * int[10]  // 나머지 값만 저장
 *
 * 2. 시간 복잡도
 * 나머지 계산: O(10)
 * 중복 검사(이중 루프): O(10^2)
 * 총합: O(1)
 *
 *
 */
