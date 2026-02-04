package baekjoon.phase5.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//연결 요소의 개수
//https://www.acmicpc.net/problem/11724
public class ConnectedComponent_11724 {
    static ArrayList<Integer>[] graph;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]); // 정점의 개수
        int M = Integer.parseInt(arr[1]); // 간선의 개수
        visited = new boolean[N + 1];

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            // 양방향 연결(= 무방향)
            graph[u].add(v);
            graph[v].add(u);
        }

        int cc = 0;

        // IMPROVED
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);   // 또는 dfs(i)
                cc++;
            }
        }
        // IMPROVED

//        int start = 1;
//        boolean visitedAll = false;
//
//        whileLoop:
//        while(!visitedAll) {
//            bfs(start);
//
//            cc++;
//
//            for(int v = 1; v < visited.length; v++) {
//                if(!visited[v]) {
//                    start = v; // start 갱신
//                    continue whileLoop;
//                }
//            }
//            visitedAll = true;
//        }

        System.out.println(cc);
    }

    static void bfs(int start) {
        // queue 생성
        Queue<Integer> queue = new LinkedList<>();

        // 방문 처리 + queue에 삽입
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int breadth : graph[node]) {
                if(!visited[breadth]) {
                    visited[breadth] = true;
                    queue.add(breadth);
                }
            }
        }
    }
}

/**
 * ArrayList[0] null
 * ArrayList[1] [2, 5]
 * ArrayList[2] [1, 5]
 * ArrayList[3] [4]
 * ArrayList[4] [3, 6]
 * ArrayList[5] [2, 1]
 * ArrayList[6] [4]
 */