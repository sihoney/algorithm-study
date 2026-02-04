package baekjoon.phase6.bfs_shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//숨바꼭질
//https://www.acmicpc.net/problem/1697
public class HideAndSeek_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); // 수빈 위치, 5
        K = Integer.parseInt(line[1]); // 동생 위치, 17

        // 📌 수정
        MAX = 100000;
        visited = new boolean[MAX + 1];
        level = new int[MAX + 1];
//        visited = new boolean[K + 2]; // ❗ 최단 경로는 반드시 K 이하의 값만 거친다는 보장이 없다
//        level = new int[K + 2]; // ❗ 최단 경로는 반드시 K 이하의 값만 거친다는 보장이 없다

        visited[N] = true;
//        level[N] = 1;
        bfs();

        System.out.println(level[K]);
    }

    static int MAX;
    static int N;
    static int K;
    static boolean[] visited;
    static int[] level;

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        // 📌 수정
        visited[N] = true;
        level[N] = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll(); // 5

//            if(curr <= 0) continue;
//            if(curr > K) continue; // 👉 K를 넘는 모든 상태를 잘라버림
            if(curr == K) break;

            for(int next : new int[]{curr-1, curr+1, curr*2}) {
                if(next < 0 || next > MAX) continue; // 인덱스 초과 여부 검사
                if(visited[next]) continue; // 방문 여부 검사

                visited[next] = true;
                level[next] = level[curr] + 1;
                queue.add(next);
            }
//            int nc = curr - 1;
//            if(!visited[nc]) {
//                visited[nc] = true;
//                queue.add(nc);
//                level[nc] = level[curr] + 1;
//            }
//
//            nc = curr + 1;
//            if(nc <= K && !visited[nc]) {
//                visited[nc] = true;
//                queue.add(nc);
//                level[nc] = level[curr] + 1;
//            }
//
//            nc = curr * 2; // nc = 20 됐을 때, 인덱스 초과 여부 검사 누락
//            if(nc <= K && !visited[nc]) {
//                visited[nc] = true;
//                queue.add(nc);
//                level[nc] = level[curr] + 1;
//            }
        }
    }
}

/**
 * 5 17
 * 걷기: X + 1 OR X - 1
 * 순간이동: 2 * X
 */