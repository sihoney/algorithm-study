package baekjoon.phase6.bfs_state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//벽 부수고 이동하기
//https://www.acmicpc.net/problem/2206
public class BreakWall_2206 {

    static int N;
    static int M;
    static boolean[][][] visited;
    static char[][] map;
    static int[][][] dist;

    static int[] nextX = {1, -1, 0, 0}; //{0, 0, -1, 1};
    static int[] nextY = {0, 0, 1, -1}; //{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); // N, row
        M = Integer.parseInt(line[1]); // M, column

        map = new char[N][M];
        for(int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
        }

        visited = new boolean[N][M][2]; // ❌ 상태 배열 차원부터 틀림 👉 반드시 [2]
        dist = new int[N][M][2];

//        int shortest = Integer.MAX_VALUE;

        int answer = bfs_me();
        System.out.println(answer);

//        for(int r = 0; r < N; r++) {
//            for(int c = 0; c < M; c++) {
//                if(map[r][c] == '1') {
//                    int dist = bfs(new Node(r,c));
//                    if(dist == 0) shortest = -1;
//                    if(dist < shortest) shortest = dist;
//                }
//            }
//        }
//        System.out.println(shortest);
    }

    static int bfs_me() {
         Queue<Node> queue = new LinkedList<>();
//         int moved = 0; // // ❌ 거리 관리가 여전히 moved++ 👉 각 상태마다 거리(dist)를 저장해야 함

        // 시작 상태
         queue.add(new Node(0, 0, 0));
         visited[0][0][0] = true;
         dist[0][0][0] = 1;

         while(!queue.isEmpty()) {
             Node curr = queue.poll();

             // 도착
             if(curr.r == N - 1 && curr.c == M - 1) {
                 return dist[curr.r][curr.c][curr.broke];
             }
//             moved++;
//             if(node.r == N - 1 && node.c == M - 1) {
////                 return moved;
//             }
//             visited[node.r][node.c][0] = true; // ❌ visited를 [r][c][0]만 쓰고 있음 👉 각 상태마다 거리(dist)를 저장해야 함

             for(int d = 0; d < 4; d++) { // 상하좌우 방문 시도
                 int nr = curr.r + nextY[d];
                 int nc = curr.c + nextX[d];

                 if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                 // 다음 칸이 길(0)
                 if(map[nr][nc] == '0') {
                     if(!visited[nr][nc][curr.broke]) {
                         visited[nr][nc][curr.broke] = true;
                         dist[nr][nc][curr.broke] = dist[curr.r][curr.c][curr.broke] + 1;
                         queue.add(new Node(nr, nc, curr.broke));
                     }
                 }
                 // 다음 칸이 벽(1) + 아직 안 부쉈다면
                 else {
                     if (curr.broke == 0 && !visited[nr][nc][1]) {
                         visited[nr][nc][1] = true;
                         dist[nr][nc][1] = dist[curr.r][curr.c][0] + 1;
                         queue.add(new Node(nr, nc, 1));
                     }
                 }
//                 if(visited[nr][nc][0]) continue;
//                 if(map[nr][nc] == '1') {
//                     if(visited)
//                 }
//                 queue.add(new Node(nr, nc));
             }
         }

         return -1; // 도달 불가
//         return moved;
    }

    static class Node {
        int r;
        int c;
        int broke; // 0: broke

        Node(int r, int c, int broke) {
            this.r = r;
            this.c = c;
            this.broke = broke;
        }
    }
}

/**
 * 2️⃣ 상태 BFS의 정석 사고 구조 (다시 정리)
 *
 * 노드 = (r, c, broke)
 * visited = visited[r][c][broke]
 * dist = dist[r][c][broke]
 *
 *
 * # 6️⃣-2. BFS + 상태 (중요 단계)
 *
 * ### 🎯 목표
 *
 * > “정점 하나 = 상태 하나”라는 생각에서 벗어나기
 *
 * ### 핵심 개념
 *
 * * `(좌표 + 상태)`를 하나의 노드로 취급
 * * 방문 배열이 2차원/3차원으로 확장됨
 *
 * ### 대표 문제
 *
 * * **2206 벽 부수고 이동하기**
 * * **14502 연구소**
 *
 * ### 핵심 사고
 *
 * > “같은 위치라도 상태가 다르면 다른 노드다”
 */