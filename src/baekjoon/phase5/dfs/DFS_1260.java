package baekjoon.phase5.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//DFS와 BFS
//https://www.acmicpc.net/problem/1260
public class DFS_1260 {
    static ArrayList<Integer>[] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]); // 정점의 개수 N 4
        int M = Integer.parseInt(arr[1]); // 간선의 개수 M 5
        int v = Integer.parseInt(arr[2]); // 탐색을 시작할 정점의 번호 V 1

        graph = new ArrayList[N + 1]; // ArrayList[0] 사용 X
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            // 양방향 연결(=무방향 연결)
            graph[a].add(b);
            graph[b].add(a);
        }

        // “정점 번호가 작은 것부터 방문”
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v ,sb);
        sb.append("\n");
        bfs(v, sb);

        System.out.println(sb.toString());
    }

    static boolean[] visited;
    static void dfs(int node, StringBuilder sb) {
        // 방문 처리
        visited[node] = true;
        // 출력
        sb.append(node).append(" ");

//        for (연결된 정점):
//            if (아직 방문 안 했으면):
//                dfs(그 정점)
        for (int next : graph[node]) { // ArrayList[3] [1, 4], ArrayList[1] [2]
            if (!visited[next]) {
                dfs(next, sb); // dfs(1, sb)
            }
        }
    }

    static void bfs(int start, StringBuilder sb) {
        boolean[] visited = new boolean[N + 1];
        //  Queue 생성 (앞으로 탐색해야 할 정점들의 대기열[순서]을 관리하는 용도)
        Queue<Integer> q = new LinkedList<>();

        // 시작점 방문 처리 + 큐에 삽입
        visited[start] = true;
        q.add(start); // [3]

        while (!q.isEmpty()) {
            // 현재 = 큐에서 하나 꺼냄
            int node = q.poll(); // ⭐ 여기서 “다음에 탐색할 정점”을 꺼냄
            // 출력
            sb.append(node).append(" ");

            // for (연결된 정점):
            for (int next : graph[node]) {
                if (!visited[next]) {
                    // 방문 처리 + 큐에 삽입
                    visited[next] = true;
                    q.add(next); // ⭐ “나중에 탐색할 정점”을 넣음
                }
            }
        }
    }
}

/**
 * DFS vs BFS
 * - DFS(Depth-First Search)
 *  한 방향으로 갈 수 있을 때까지 끝까지 같다
 * - BFS(Breadth-First Search)
 *  가까운 것부터 차례대로 넓게 퍼져 나간다
 *
 * 1️⃣ DFS(깊이 우선 탐색)
 *| 항목    | 내용              |
 * | ----- | --------------- |
 * | 탐색 순서 | 깊이 우선           |
 * | 구현    | 재귀 / Stack      |
 * | 장점    | 구현 간단, 구조 파악 좋음 |
 * | 단점    | 최단 거리 ❌         |
 * | 주의    | 방문 체크 없으면 무한 루프 |
 *
 * 2️⃣ BFS (너비 우선 탐색)
 * | 항목    | 내용          |
 * | ----- | ----------- |
 * | 탐색 순서 | 거리(레벨) 순    |
 * | 구현    | Queue       |
 * | 장점    | 최단 거리 보장    |
 * | 단점    | 메모리 사용 ↑    |
 * | 주의    | 방문 체크 시점 중요 |
 *
 *
 */
