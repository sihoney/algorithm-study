package baekjoon.phase4.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//소트인사이드
//https://www.acmicpc.net/problem/1427
public class SortInside_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();

        int count = 0;
        while(count < arr.length - 1) {
            count = 0; // 초기화
            int accu = arr[0] - '0';

            for(int idx = 1; idx < arr.length; idx++) {
                int curr = arr[idx] - '0';

                if(curr > accu) {
                    arr[idx] = (char) (accu + '0'); // int -> char
                    arr[idx - 1] = (char) (curr + '0');
                } else {
                    count++;
                }

                accu = arr[idx] - '0';
            }
        }

        for(char c : arr) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}

/**
 * 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬
 */
