package programmers.hash;

import java.util.HashMap;

// 완주하지 못한 선수
// https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java
public class Solution01 {
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};

		// ==============================================
		String answer = "";
		HashMap<String, Integer> hashMap = new HashMap<>();

		for(String name : participant) {
			hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
		}

		for(String completed : completion) {
			if(hashMap.containsKey(completed)) {
				if(hashMap.get(completed) > 1) { // 동명이인
					hashMap.replace(completed, hashMap.get(completed) - 1);
				} else {
					hashMap.remove(completed);
				}
			}
		}

		answer = hashMap.entrySet().iterator().next().getKey();
		System.out.println(answer);
	}
}
