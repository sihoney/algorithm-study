package baekjoon.phase6.dfs_components;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//유기농 배추
//https://www.acmicpc.net/problem/1012
public class Cabbage_1012 {
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 T

        while(T-- > 0) {
            String[] line = br.readLine().split(" ");
            M = Integer.parseInt(line[0]); // 가로길이 M (row)
            N = Integer.parseInt(line[1]); // 세로길이 N (column)
            int K = Integer.parseInt(line[2]); // 배추가 심어져 있는 위치의 개수 K

            visited = new boolean[N][M];
            map = new int[N][M]; // int[8][10]

            for (int i = 0; i < K; i++) {
                String[] loca = br.readLine().split(" ");
                int x = Integer.parseInt(loca[0]); // X(0 ≤ X ≤ M-1),
                int y = Integer.parseInt(loca[1]); // Y(0 ≤ Y ≤ N-1)

                map[y][x] = 1;
            }

            int worm = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (visited[r][c]) continue; // Index 8 out of bounds for length 8
                    if (map[r][c] == 0) continue;

                    dfs(r, c);
                    worm++;
                }
            }

            sb.append(worm).append("\n");
        }

        System.out.println(sb);
    }

    static int[] nextX = {0, 0, -1, 1};
    static int[] nextY = {1, -1, 0, 0};

    // depth first searching
    static void dfs(int r, int c) {
//        if(map[y][x] == 0) {
//            visited[y][x] = true;
//            return;
//        }

        visited[r][c] = true; //  방문 처리

        for(int i = 0; i < 4; i++) {
            int nr = r + nextX[i];
            int nc = c + nextY[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (visited[nr][nc]) continue;
            if (map[nr][nc] == 0) continue;

            dfs(nr, nc);
        }
    }
}
