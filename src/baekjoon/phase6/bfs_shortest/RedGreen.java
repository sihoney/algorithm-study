package baekjoon.phase6.bfs_shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 적록색약
// https://www.acmicpc.net/problem/10026
public class RedGreen {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[][] grid = new String[N][];

		for(int i = 0; i < N; i++) {
			grid[i] = br.readLine().split("");
		}

		boolean[][] visited = new boolean[N][N];

		// hint: 일반인용  BFS
		int count1 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {

				if(!visited[i][j]) {
					bfs(grid, visited, i, j);
					count1++;

				}
			}
		}

		// hint: 적록색약용: G -> R 치환 후 동일하게 BFS
		// grid2에서 'G'를 'R'로 바꾸고 똑같이 count2 구하기
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				if(grid[i][j].equals("G")) {
					grid[i][j] = "R";
				}
			}
		}

		visited = new boolean[N][N];
		int count2 = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {

				if(!visited[i][j]) {
					bfs(grid, visited, i, j);
					count2++;
				}
			}
		}

		System.out.println(count1 + " " + count2);
	}

	static void bfs(String[][] grid, boolean[][] visited, int i, int j) {
		// hint: BFS는 반드시 Queue를 사용해야 해요!
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{i, j});
		visited[i][j] = true;

		// hint: 상하좌우 탐색 시, 현재 칸과 같은 색인 경우만 큐에 추가
		// hint: 상하좌우를 방향 배열로 처리, 지금 코드는 직접 조작
		int[] dx = {-1, 1, 0, 0}; // 상, 하
		int[] dy = {0, 0, -1, 1}; // 좌, 우

		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];

			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				// hint: 범위 체크 + 미방문 + 같은 색
				if(nx >= 0 && nx < grid.length
				&& ny >= 0 && ny < grid.length
				&& !visited[nx][ny]
				&& grid[nx][ny].equals(grid[i][j])) {

					visited[nx][ny] = true;
					queue.add(new int[]{nx, ny});
				}
			}
		}
	}
}

/**
 * hint: dfs/dfs를 두 번 돌리는 문제
 * 두 가지 경우의 구역 수를 구해야 해요.
 *
 * hint: 알고리즘 선택
 *
 * hint: 두 번 풀기
 * 1번 bfs -> 원본 그리드로 구역 수 카운트(일반인)
 * 2번 bfs -> G를 R로 바꾼 그리드고 구역 수 카운트(적록색약)
 */