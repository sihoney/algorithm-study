package baekjoon.phase2.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 과제 안 내신 분..?
// https://www.acmicpc.net/problem/5597
public class Missing_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[31];

        for(int i = 0; i < 28; i++) {
            arr[Integer.parseInt(br.readLine())] = 1;
        }

        for(int i = 1; i < 31; i++) {
           if(arr[i] == 0) {
               System.out.println(i);
           }
        }
    }
}

/**
 * 1. 메모리 그림
 * Stack:
 * main()
 *  ├─ i
 *  ├─ n (입력 읽을 때 잠깐 생성)
 *  └─ arr (reference)
 *
 * Heap:
 * int[31]  ← 31칸 고정 공간
 *
 * 2. 시간 복잡도
 * 입력 처리: O(28)
 * 출력 검사: O(30)
 * 총합: O(1)  (상수 시간)
 */
