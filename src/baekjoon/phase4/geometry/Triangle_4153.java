package baekjoon.phase4.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//직각삼각형
//https://www.acmicpc.net/problem/4153
public class Triangle_4153 {
    public static void main_01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] line = br.readLine().split(" ");

            // string -> int
            int[] arr = Arrays.stream(line)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if(arr[0] == 0) break;

            // 정렬
            int count = 0; // 위치 변동 안 한 횟수
            while(count < 2) {
                int accu = arr[0];
                count = 0; // 초기화

                for(int idx = 1; idx < 3; idx++) {
                    int curr = arr[idx];

                    if(accu > curr) {
                        arr[idx] = accu;
                        arr[idx - 1] = curr;
                    } else {
                        count++;
                    }

                    accu = arr[idx];
                }
            }

            // 직각 삼각형 확인
            if(Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

/**
 * 각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력
 * - 마지막줄에는 0 0 0이 입력
 */
