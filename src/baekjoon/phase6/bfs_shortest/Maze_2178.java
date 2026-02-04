package baekjoon.phase6.bfs_shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//미로 탐색
//https://www.acmicpc.net/problem/2178
public class Maze_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        maze = new char[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        for(int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();

            maze[i] = row;
        }

        /**
         * 4 6
         * 101111
         * 101010
         * 101011
         * 111011
         */

        System.out.println(bfs());
    }

    static int N;
    static int M;
    static boolean[][] visited;
    static char[][] maze;
    static int[][] dist;

    // 인접 우선 탐색
    static int bfs() {
        Queue<Node> queue = new LinkedList<>(); // 탐색 순서 큐
        // ❌ minRoute++ 로 거리를 세고 있음
        // BFS에서 큐에서 꺼내는 순서 = 탐색 순서
        // 이동 거리 순서가 아님
//        int minRoute = 0;

        // ✅ 이렇게 바뀌어야 함
        dist[0][0] = 1;
        visited[0][0] = true;
        queue.add(new Node(0, 0));

//        visited[start.r][start.c] = true;
//        queue.add(start);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
//            visited[node.r][node.c] = true; // 방문 처리 👉 너무 늦음

//            minRoute++;

//            System.out.printf("node(%d, %d)%n", node.r,node.c); // node(0, 0)

            // 종료 조건
            // ✅ 이렇게 바뀌어야 함
            if (node.r == N - 1 && node.c == M - 1) {
                return dist[node.r][node.c];
            }

            int[] dr = {0, 0, 1, -1};
            int[] dc = {1, -1, 0, 0};

            for(int d = 0; d < 4; d++) {
                int nr = node.r + dr[d];
                int nc = node.c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(maze[nr][nc] == '0') continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true; // 방문 처리
                dist[nr][nc] = dist[node.r][node.c] + 1; // 거리 누적 처리
                queue.add(new Node(nr, nc)); // 큐에 이동할 노드 추가
            }
        }

        return dist[N][M];
    }

    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

/**
 *  (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수
 *
 * 📌 미로 탐색 (2178)
 *
 * 0/1 명확
 *
 * 시작점과 도착점이 정해져 있음
 *
 * BFS = “거리 늘려가기” 개념
 *
 * 👉 이 문제에서 배울 것:
 *
 * 큐의 역할
 *
 * visited 체크 시점
 *
 * 상하좌우 패턴 고정
 */