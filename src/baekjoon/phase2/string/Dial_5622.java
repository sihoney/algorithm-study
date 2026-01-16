package baekjoon.phase2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다이얼
// https://www.acmicpc.net/problem/5622
public class Dial_5622 {

    static final char[] DIAL = {'C', 'F', 'I', 'L', 'O', 'S', 'V', 'Z'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int sec = 0;
        for(int i = 0; i < arr.length; i++) {
            sec += calcDial(arr[i]) + 1;
        }

        System.out.println(sec);
    }

    static int calcDial(char c) {
//        char[] arr = {'C', 'F', 'I', 'L', 'O', 'S', 'V', 'Z'};

        int dial = 0;

         for(int i = 0; i < DIAL.length; i++) {
             if(c <= DIAL[i]) {
                 dial = i;
                 break;
             }
         }

         return dial + 2;
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ sec
 *  ├─ i
 *  └─ c
 *
 * Heap:
 * char[] 입력 문자열
 * char[] 다이얼 경계 배열
 *
 * 2. 시간 복잡도
 * 문자열 길이 = N
 * calcDial 내부 = 8번 비교
 *
 * 총합: O(8N) ≈ O(N)
 */
