package baekjoon.phase6.bfs_shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 헌내기는 친구가 필요해
// https://www.acmicpc.net/problem/21736
public class NeedFriend {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);

		String[][] campus = new String[N][];

		for(int r = 0; r < N; r++) {
			campus[r] = br.readLine().split("");
		}

		boolean[][] visited = new boolean[N][M];

		// O: 빈 공간,
		// x: 벽,
		// I: 도연이,
		// P: 사람
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				if(campus[x][y].equals("I")) {
					// System.out.println("found 도연!");

					int result = bfs(campus, visited, x, y);
					if(result == 0) {
						System.out.println("TT");
					} else {
						System.out.println(result);
					}
				}
			}
		}

		// 도연이가 만날 수 있는 사람의 수를 출력, 아무도 만나지 못한 경우 TT 출력
	}

	static int bfs(String[][] campus, boolean[][] visited, int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{startX, startY});

		int count = 0;

		visited[startX][startY] = true;
		//  Cannot store to byte/boolean array because "visited[x]" is null

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currX = curr[0];
			int currY = curr[1];

			/* 테스트용 */
			// for(int i = 0; i < campus.length; i++) {
			// 	for(int j = 0; j < campus[i].length; j++) {
			// 		if(visited[i][j]) {
			// 			System.out.print("*");
			// 		} else {
			// 			System.out.print(campus[i][j]);
			// 		}
			// 	}
			// 	System.out.println();
			// }
			// System.out.println("***************************************");
			/* 테스트용 */

			for (int d = 0; d < 4; d++) {
				// hint: 시작점 x, y 고정 ❌
				int nx = currX + dx[d];
				int ny = currY + dy[d];

				// 범위 검증 & 방문 검증
				if (nx >= 0 && nx < campus.length
					&& ny >= 0 && ny < campus[0].length
					&& !visited[nx][ny]) {
					visited[nx][ny] = true;

					if(campus[nx][ny].equals("O")) {
						// 빈 공간 -> 이동 예정 queue에 넣기
						queue.add(new int[]{nx, ny});
						// System.out.println("빈공간발견!");
					}
					else if(campus[nx][ny].equals("P")) {
						// 사람 -> 이동 예정 queue에 넣기, count++
						queue.add(new int[]{nx, ny});
						count++;
						// System.out.println("사람발견!: " + count);
					}
				}
			}
		}

		return count;
	}
}
