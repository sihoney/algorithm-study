package baekjoon.phase6.bfs_state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 토마토
// https://www.acmicpc.net/problem/7576
public class Tomato {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수

		String[] arr = br.readLine().split(" ");
		int M = Integer.parseInt(arr[0]); // 가로 칸의 수
		int N = Integer.parseInt(arr[1]); // 세로 칸의 수

		int[][] storage = new int[N][M];

		for(int r = 0; r < N; r++) {
			int[] row = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

			storage[r] = row;
		}

		boolean[][] visited = new boolean[N][M];
		int totalDays = 0;
		Queue<int[]> queue = new LinkedList<>();
		int unripe = 0;

		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {

				if(storage[r][c] == 1) {
					// System.out.println(">> 익은토마토발견!");
					queue.add(new int[]{r, c, 0});
				} else if(storage[r][c] == 0) {
					unripe++;
				}
			}
		}

		int[] result = bfs(storage, visited, queue, unripe);
		totalDays = result[0];
		unripe = result[1];

		// 저장될 때부터 모든 토마토가 익어익는 상태, 0 출력
	 	// 모두 익지는 못하는 상황, -1 출력
		if(unripe > 0) {
			System.out.println(-1);
		} else {
			System.out.println(totalDays);
		}
	}

	static int[] bfs(
		int[][] storage,
		boolean[][] visited,
		Queue<int[]> queue,
		int unripe
	) {

		int day = 0; // 모든 토마토가 익어있는 상태

		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currX = curr[0];
			int currY = curr[1];
			day = curr[2];

			// 💡 hint: visited 배열 역할 중복
			// (visited 체크를 큐에서 꺼낼 때 수행, 같은 칸이 큐에 여러 번 들어갈 수 있음)
			// visited[currX][currY] = true;
			// unripe--;

			// ========= test =========
			// for(int i = 0; i < visited.length; i++) {
			// 	for(int j = 0; j < visited[0].length; j++) {
			// 		if(i == currX && j == currY) {
			// 			System.out.print("'" + day + "'");
			// 			// System.out.print("#");
			// 		} else {
			// 			System.out.print(storage[i][j]);
			// 		}
			// 	}
			// 	System.out.println();
			// }
			// System.out.println("*****************************");

			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			for(int d = 0; d < 4; d++) {
				int nx = currX + dx[d];
				int ny = currY + dy[d];

				if(nx >= 0 && nx < storage.length
					&& ny >= 0 && ny < storage[0].length
					&& !visited[nx][ny]
					&& storage[nx][ny] == 0) {

					// 💡 hint: 큐에 넣을 때 visited 처리
					visited[nx][ny] = true;
					unripe--;

					queue.add(new int[]{nx, ny, day + 1});
					// System.out.println(">> 안익은토마토발견!");
				}
			}

			// days++;
		}

		return new int[]{day, unripe};
		// return days;
	}

}

/**
 * [BFS 확장 (상태 관리)]
 *
 * 핵심 포인트
 * - 여러 시작점 BFS
 * - 큐에 초기값 여러 개 넣기
 *
 * 핵심 사고
 * - 하루 = BFS 한 레벨
 */