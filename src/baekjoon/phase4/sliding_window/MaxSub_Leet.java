package baekjoon.phase4.sliding_window;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Maximum Subarray
// https://leetcode.com/problems/maximum-subarray/description/
public class MaxSub_Leet {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 최대 합을 가지는 부분 배열을 찾아라!
		// 최대 합을 반환!

		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int result; // 6 [4, -1, 2, 1]
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;

		for(int i = 0; i < nums.length; i++) {
			currSum = Math.max(currSum + nums[i], nums[i]);
			// if(currSum + nums[i] < nums[i]) {
			// 	currSum = nums[i];
			// }
			// else {
			// 	currSum += nums[i];
			// }

			maxSum = Math.max(maxSum, currSum);
			// if(maxSum < currSum) maxSum = currSum;
		}

		System.out.println(maxSum);
	}
}

/**
 * - 윈도우 크기가 고정 X --> 슬라이딩 윈도우 적합 X
 *
 * - hint: "이전까지의 합을 이어갈지, 여기서 새로 시작할지"를
 * 매 원소마다 결정하는 방식을 생각해보세요
 *
 * - hint: 배열을 순회하면서 각 원소마다 이런 선택을 해야 합니다:
 * "이전까지 누적한 합에 나를 더하는 게 나을까, 아니면 나부터 새로 시작하는 게 나을까?"
 *
 * - hint: Kadane's Algorithm
 * "이전 합 + 나" vs "나 혼자" -> 둘 중 더 큰 걸 선택!
 */