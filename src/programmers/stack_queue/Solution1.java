package programmers.stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1 {
	public static void main(String[] args) {
		int []arr = {1,1,3,3,0,1,1};

		List<Integer> list = new ArrayList<>();

		int lastValue = -1; // 원소가 0~9이므로 초기값은 -1
		for (int num : arr) {
			if (num != lastValue) {
				list.add(num);
				lastValue = num;
			}
		}

		// Stream 대신 일반 for문으로 배열 변환
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		// return answer;
	}
}
