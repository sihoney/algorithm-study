package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon2447 {
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
        // pattern_accu = new char[1][1] {['*']} (?)

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
