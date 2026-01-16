package baekjoon.phase2.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최댓값
// https://www.acmicpc.net/problem/2562
public class Max_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        [더 범용적인 패턴] -> 1) Integer.MIN_VALUE 2) 첫 입력을 기준으로
        int max = Integer.parseInt(br.readLine());
        int idx = 1;

        for(int i = 2; i <= 9; i++) {
            int v = Integer.parseInt(br.readLine());

            if(v > max) {
                max = v;
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
    public static void main_before(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int idx = 0;

        for(int i = 0; i < 9; i++) {
            int v = Integer.parseInt(br.readLine());

            if(v > max) {max = v; idx = i + 1;}
        }

        System.out.println(max);
        System.out.println(idx);
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ max
 *  ├─ idx
 *  ├─ v
 *  └─ i
 *
 * Heap:
 * (BufferedReader 내부 버퍼만 존재)
 *
 * 2. 시간 복잡도
 * 입력 횟수: 9
 * 비교: 9
 * 총합: O(1)
 */
