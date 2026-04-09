package baekjoon.phase6.bfs_shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

// 알고리즘 수업 - 너비 우선 탐색 2
// https://www.acmicpc.net/problem/24445
public class BfsClass {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]); // 정점의 수
		int M = Integer.parseInt(arr[1]); // 간선의 수
		int R = Integer.parseInt(arr[2]); // 시작 정점

		Set<Integer>[] graph = new HashSet[N + 1];
		for(int i = 1; i <= N; i++) graph[i] = new HashSet<>();

		boolean[] visited = new boolean[N + 1];

		for(int i = 0; i < M; i++) {
			String[] uv = br.readLine().split(" ");
			int u = Integer.parseInt(uv[0]);
			int v = Integer.parseInt(uv[1]);

			// 양방향 간선
			graph[u].add(v);
			graph[v].add(u);
		}

		int[] result = bfs(graph, visited, R);

		for(int i : result)
			System.out.println(i);

		// N개의 줄에 정수를 한 개씩 출력
		// i번째 줄에는 정점 i의 방문 순서를 출력
	}

	// v: 정점 집합, e: 간선 집합, r: 시작 정점
	static int[] bfs(Set<Integer>[] graph, boolean[] visited, int node) {
		Queue<Integer> queue= new LinkedList<>();
		queue.add(node);

		int[] orders = new int[visited.length - 1];
		int order = 1;

		visited[node] = true;
		orders[node - 1] = order;

		while(!queue.isEmpty()) {
			int currNode = queue.poll();

			List<Integer> sorted = graph[currNode].stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

			for(int bn : sorted) {
				if(!visited[bn]) {
					order++;
					visited[bn] = true;
					queue.add(bn);
					orders[bn - 1] = order;
				}
			}
		}

		return orders;
	}
}
