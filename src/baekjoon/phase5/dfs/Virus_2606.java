package baekjoon.phase5.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//바이러스
//https://www.acmicpc.net/problem/2606
public class Virus_2606 {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] infected; // 방문 체크 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 컴퓨터의 수, 7
        int M = Integer.parseInt(br.readLine()); //네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

        graph = new ArrayList[N + 1]; // graph[0] -> 사용 X
        infected = new boolean[N + 1];

        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 직접 연결되어 있는 컴퓨터의 번호 쌍
        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            graph[a].add(b);
            graph[b].add(a); // 양방향 연결!(=무방향 연결)
        }

        // dfs 탐색
        dfs(1);

        int infectedSum = 0;
        for(int i = 2; i < infected.length; i++) {
            if(infected[i]) infectedSum++;
        }

        System.out.println(infectedSum);
    }

    static void dfs(int node) {

        // 1. 현재 노드 방문 처리 (감염!)
        infected[node] = true;

        // 2. 현재 노드와 연결된 친구들을 하나씩 꺼내기
        for (int next : graph[node]) {
            if (!infected[next]) {   // ⭐ 핵심
                dfs(next);
            }
        }
//        for(int i = 0; i < graph[node].size(); i++) {
//            dfs(graph[node].get(i)); // 👉 이미 방문한 노드인지 확인하지 않고 다시 dfs 호출
//        }
    }
}

/**
 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
 *
 * DFS(Depth-First Search, 깊이 우선 탐색)
 * - 그래프나 트리 같은 자료구조에서 '일단 한 놈만 끝까지 팬다'는 전략으로 데이터를 찾는 방법
 * - 재귀와 DFS는 서로 다른 개념이라기보다, '재귀가 DFS를 구현하는 가장 대표적인 도구(방법)'
 *
 * - 특징: 최대한 깊이 내려갔다가, 더 이상 갈 곳이 없으면 옆으로 이동
 * - 준비물: "내가 어디를 방문했었나?"를 기록할 방문 체크 배열이 꼭 필요합니다. (안 그러면 무한 루프에 빠져요!)
 */