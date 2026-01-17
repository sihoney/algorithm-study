package baekjoon.phase3.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 체스판 다시 칠하기
// https://www.acmicpc.net/problem/1018
public class ChessboardRepaint_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 8 <= N/M <= 50
        int M = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[N][M];

        for(int r = 0; r < N; r++) {
            char[] row = br.readLine().toCharArray();

            for(int c = 0; c < M; c++) {
                if(row[c] == 'W') board[r][c] = true;
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int a = 0; a <= N - 8; a++) {
            for (int b = 0; b <= M - 8; b++) {

                int repaintW = 0; // (a,b)를 W로 가정
                int repaintB = 0; // (a,b)를 B로 가정

                for (int r = a; r < a + 8; r++) {
                    for (int c = b; c < b + 8; c++) {

                        boolean current = board[r][c];
                        boolean expectedW = ((r + c) % 2 == 0);

                        if (current != expectedW) repaintW++;
                        if (current == expectedW) repaintB++;
                        // repaintB는 반대니까 이렇게도 가능
                    }
                }

                answer = Math.min(answer, Math.min(repaintW, repaintB));
            }
        }

    }
}