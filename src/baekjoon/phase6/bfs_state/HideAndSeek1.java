package baekjoon.phase6.bfs_state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 숨바꼭질
// https://www.acmicpc.net/problem/1697
public class HideAndSeek1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		 String[] arr = br.readLine().split(" "); // 1 0
		 int N = Integer.parseInt(arr[0]); // 수빈 위치
		 int K = Integer.parseInt(arr[1]); // 동생 위치(0 <= K <= 100,000)

		 // 💡 visited 배열이 없어요. (방문 체크 없음 -> 같은 위치를 무한 반복 탐색 가능)
		boolean[] visited = new boolean[100000 + 1];

		 // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하시오.
		System.out.println(bfs(N, K, visited));
	}

	static int bfs(int start, int dest, boolean[] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{start, 0}); // 1, 0

		// 💡N == K 일 때 처리가 없어요.
		if(start == dest) return 0;

		while(!queue.isEmpty()) {
			int[] currNode = queue.poll();
			int curr = currNode[0];
			int seconds = currNode[1];

			if(curr == dest) return seconds; // 💡꺼낼 때 체크!

			// visited[curr] = true;
			// System.out.println("seconds: " + seconds + ", curr: " + curr);

			// int o1 = curr - 1;
			// int o2 = curr + 1;
			// int o3 = curr * 2;

			// 💡 도착 체크와 큐 삽입이 분리되어 있음, BFS 정석 패턴은 큐에서 꺼낼 때 도착 체크
			// if(o1 == dest) {
			// 	return seconds + 1;
			// } else if(o2 == dest) {
			// 	return seconds + 1;
			// } else if(o3 == dest) {
			// 	return seconds + 1;
			// }

			for(int next : new int[]{curr-1,curr+1,curr*2}) {
				if(next >= 0 && next <= 100000 && !visited[next]) {
					visited[next] = true; // 💡넣을 때 visited 처리
					queue.add(new int[]{next, seconds + 1});
				}
			}

			// 💡 dest 이하로만 제한 -> dest보다 큰 경우를 못 탐색
			// if(o1 >= 0 && o1 <= 100000 && !visited[o1]) queue.add(new int[]{o1, seconds + 1});
			// if(o2 >= 0 && o2 <= 100000 && !visited[o2]) queue.add(new int[]{o2, seconds + 1});
			// if(o3 >= 0 && o3 <= 100000 && !visited[o3]) queue.add(new int[]{o3, seconds + 1});

		}

		return -1;
	}
}

/**
 * [상태 기반 탐색]
 *
 * 핵심
 * - 좌표가 아니라 "값 상태"
 * - 위치 -> 숫자 상태
 *
 */
