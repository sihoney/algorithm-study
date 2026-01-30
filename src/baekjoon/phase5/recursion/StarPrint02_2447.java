package baekjoon.phase5.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//별 찍기 - 10
//https://www.acmicpc.net/problem/2447
public class StarPrint02_2447
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 3의 거듭제곱(3, 9, 27, 81, ...)

        starBox(N);

        for(int i = 0; i < pattern_curr.length; i++) {
            char[] row = pattern_curr[i];

            for(int j = 0; j < row.length; j++) {
                sb.append(row[j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static char[][] pattern_accu;
    static char[][] pattern_curr;

    static void starBox(int n) { // n = 3
        if(n == 1) {
            pattern_curr = new char[1][1];
            pattern_curr[0][0] = '*';
            return;
        }

        starBox(n / 3); // starBox(1)

        // accu 갱신
        pattern_accu = pattern_curr;

        // accu -> curr 확대 복사
        pattern_curr = new char[n][n];
        for(int i = 0; i < n; i++) { // 0, 1, 2
            for(int j = 0; j < n; j++) {

                if(j >= n / 3
                        && j < (n / 3) * 2
                        && i >= n / 3
                        && i < (n / 3) * 2
                ) {
                    pattern_curr[i][j] = ' ';
                } else {
                    pattern_curr[i][j] = pattern_accu[i % (n / 3)][j % (n / 3)];
                }
            }
        }

    }
}

/**
 *  N이 3의 거듭제곱(3, 9, 27, 81, ...)
 *  크기 N의 패턴은 N×N 정사각형 모양
 *  크기 3의 패턴, 가운데에 공백
 *  N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태
 *
 *  1. 종료 조건
 *  n == 1
 *
 *  2. 현재 호출 책임
 *  이전 (n - 1) 호출에서 제공한 패턴으로 새 패턴 만들기
 *
 *  3. 나머지는 누구에게 맡길까?
 *
 */
