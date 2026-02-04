package baekjoon.phase5.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//단지번호붙이기
//https://www.acmicpc.net/problem/2667
public class Numbering_2667 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 지도의 크기 N, 7

//        graph = new ArrayList[N + 1];
//        for(int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        char[][] map = new char[N][N];

        for(int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray(); // 0110100
            map[i] = row;
        }

        visited = new boolean[N][N];
        int complex = 0;
        ArrayList<Integer> complexCnt = new ArrayList<>();

        for(int i = 0; i < N; i++) {    // char[][] map 조회
            for(int j = 0; j < N; j++) {
                if(map[i][j] == '0') { // 0인 경우, 다음으로 이동
                    continue;
                }

                // 1인 경우, bfs 탐색 시작!, 덩어리 개수를 반환
                // ❌ “새 단지는 ‘1이면서 아직 방문 안 한 곳’에서만 시작한다”
                if (map[i][j] == '1' && !visited[i][j]) {
                    complexCnt.add(bfs(new Node(i, j))); // 덩어리 개수
                    complex++; // 단지 수 ++
                }
            }
        }

        Collections.sort(complexCnt);

        sb.append(complex).append("\n");

        for(int cnt : complexCnt) {
            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }

    static char[][] map;
//    static ArrayList<Node>[] graph;
    static boolean[][] visited;

    /**
     * char[][] map
     * 0110100
     * 0110101
     * 1110101
     * 0000111
     * 0100000
     * 0111110
     * 0111000
     */

    static int bfs(Node start) {
        // queue 생성
        Queue<Node> queue = new LinkedList<>();

        int count = 0;

        // 시작 노드, 방문 처리 '시작 노드는 항상 1"
        visited[start.r][start.c] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            // ❌ 큐에는 항상 1인 칸만 들어가야 정상, map == '0' 검사 → 큐에 넣기 전에 해야 함
            if(map[node.r][node.c] == '0') { // 탐색 정점이 0인 경우
//                break;
                continue;
            } else { // 탐색 정점이 1인 경우
                count++;

                // 인근 노드을 방문하지 않은 경우 -> 방문 처리 & 탐색 queue에 추가
                // 왼쪽, 오른쪽, 아래
                // ❌
                if(node.r < N - 1 && node.c > 0 && node.c < N - 1) {

                    if(!visited[node.r][node.c - 1]) {
                        visited[node.r][node.c - 1] = true;
                        queue.add(new Node(node.r, node.c - 1));
                    }

                    if(!visited[node.r][node.c + 1]) {
                        visited[node.r][node.c + 1] = true;
                        queue.add(new Node(node.r, node.c + 1));
                    }

                    if(!visited[node.r + 1][node.c]) {
                        visited[node.r + 1][node.c] = true;
                        queue.add(new Node(node.r + 1, node.c));
                    }

                }
            }
        }

        return count;
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
 * 총 단지 수
 * 각 단지 내 집의 수 (오름차순 정렬)
 */
