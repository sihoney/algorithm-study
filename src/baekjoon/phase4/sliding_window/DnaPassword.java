package baekjoon.phase4.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// DNA 비밀번호
// https://www.acmicpc.net/problem/12891
public class DnaPassword {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");

		int S = Integer.parseInt(arr[0]); // dna 문자열 길이
		int P = Integer.parseInt(arr[1]); // 부분문자열의 길이

		String dnaStr = br.readLine();

		String[] arr2 = br.readLine().split(" ");

		int minA = Integer.parseInt(arr2[0]); // 부분문자열에 포함되어야 할 최소 개수
		int minC = Integer.parseInt(arr2[1]);
		int minG = Integer.parseInt(arr2[2]);
		int minT = Integer.parseInt(arr2[3]);

		int result = 0; // 만들 수 있는 비밀번호의 종류의 수

		Map<Character, Integer> map = new HashMap<>();

		// String p = dnaStr.substring(0, P);

		dnaStr.substring(0, P - 1).chars().forEach(c -> {
			char ch = (char) c;

			map.put(ch, map.getOrDefault(ch, 0) + 1);
		});

		for(int i = 0; i + P <= S; i++) {
			char lastChar = dnaStr.charAt(i + P - 1);
			map.put(lastChar, map.getOrDefault(lastChar, 0) + 1);

			if((minA == 0 || map.getOrDefault('A', 0) >= minA) &&
				(minC == 0 || map.getOrDefault('C', 0)  >= minC) &&
				(minG == 0 || map.getOrDefault('G', 0) >= minG) &&
				(minT == 0 || map.getOrDefault('T', 0) >= minT)) {
				result++;
			}

			char startChar = dnaStr.charAt(i); // 첫 문자를 누적값에서 제외
			map.put(startChar, map.get(startChar) - 1);
		}

		System.out.println(result);
	}
}

/**
 * [슬라이딩 윈도우]
 *
 * 신호
 * - 연속 구간
 * - "길이 k" 또는 "연속된 부분"
 *
 * 핵심 이유
 * - 이전 결과를 재사용 가능
 */