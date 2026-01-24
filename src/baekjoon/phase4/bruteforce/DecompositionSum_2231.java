package baekjoon.phase4.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//분해합
//https://www.acmicpc.net/problem/2231
public class DecompositionSum_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ds = Integer.parseInt(br.readLine()); // 분해합, 1 ≤ N ≤ 1,000,000

        int cn_min = 0;
//        cs: 생성자
        for(int cn = 1; cn <= ds; cn++) {
            if(ds != makeDS(cn)) continue;

            cn_min = cn;
            break;
        }

        System.out.println(cn_min);
    }

    static int makeDS(int cn) {
        int ds = cn;
        while(cn > 0) {
            ds += cn % 10;
            cn /= 10;
        }
        return ds;
    }
}

/**
 * 자연수 N의 분해합: N과 N을 이루는 각 자리수의 합
 * 자연수 M의 분해합이 N인 경우, M을 N의 생성자
 * 245의 분해합은 256(=245+2+4+5)
 * 245는 256의 생성자
 *
 * 출력: N의 가장 작은 생성자
 * 생성자가 없는 경우에는 0을 출력
 *
 * 📌 **조건을 함수로 바꾸는 연습**
 *
 * * “생성자” 개념
 * * 수를 구성 요소로 분해
 * * 상한선을 논리로 제한
 *
 * 👉 이후 **백트래킹 사고의 씨앗**
 */