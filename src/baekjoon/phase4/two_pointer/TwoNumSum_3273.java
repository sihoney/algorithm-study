package baekjoon.phase4.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 두 수의 합
// https://www.acmicpc.net/problem/3273
public class TwoNumSum_3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		// int[] arr = new int[n];

		String[] strArr = br.readLine().split(" ");

		int x = Integer.parseInt(br.readLine());

		int[] list = Arrays.stream(strArr)
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();
		// 1 2 3 5 7 9 10 11 12

		int result = 0;

		int p1 = 0;
		int p2 = list.length - 1;

		// 중첩 for문 -> while문
		while(p1 < p2) {
			if(list[p1] + list[p2] == x) {
				result++;

				p1++;
				p2--;
			} else if(list[p1] + list[p2] > x) {
				// 합이 큰 경우, 오른쪽 포인터를 왼쪽으로 이동
				p2--;
			} else {
				// 합이 작은 경우, 왼쪽 포인터를 오른쪽으로 이동
				p1++;
			}
		}

		System.out.println(result);
	}
}

/**
 * [투포인터]
 *
 * 신호
 * - 배열
 * - "두 개 / 세 개 조합"
 * - 정렬 가능
 *
 * 핵심 이유
 * - 정렬 후 양쪽에서 좁히면 경우의 수 줄일 수 있음
 */