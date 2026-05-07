package programmers.hash;

import java.util.HashSet;

// 폰켓몬
// https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class Solution2 {
	public static void main(String[] args) {
		int[] nums = {3,3,3,2,2,2};
	// 	====================================
		int answer = 0;

		int n = nums.length / 2;

		HashSet<Integer> hs = new HashSet<>();

		for(int i : nums) {
			hs.add(i);
		}

		System.out.println(Math.min(hs.size(), n));

		// return answer;
		// 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그 때의 폰켓몬 종류 번호의 개수를 반환
	}
}
