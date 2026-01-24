package baekjoon.phase4.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

//체스판 다시 칠하기
//https://www.acmicpc.net/problem/1018
public class ChessboardRepaint_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]); // 8보다 크거나 같고, 50보다 작거나 같은 자연수
        int M = Integer.parseInt(arr[1]);

        char[][] board = new char[N][M];

        for(int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int min_paint = Integer.MAX_VALUE;
        for(int r = 0; r < N - 8 + 1; r++) {
            for(int c = 0; c < M - 8 + 1; c++) {

                int paint = 0;
                for(int i = r; i < r + 8; i++) {
                    for(int j = c; j < c + 8; j++) {
                        char curr = board[i][j];

                        if((j + i) % 2 == 0) {
                            if(curr == 'B') continue;

                            paint++;
                        } else {
                            if(curr == 'W') continue;

                            paint++;
                        }
                    }
                }
                min_paint = Math.min(min_paint, Math.min(paint, (8 * 8) - paint));
            }
        }

        System.out.println(min_paint);
    }
}

/**
 * 0 1 2 3 4 5 6 7
 * B B B W B W B W
 * 1
 * 7
 *
 *  다시 칠해야 하는 정사각형 개수의 최솟값을 출력
 */