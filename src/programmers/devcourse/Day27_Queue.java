package programmers.devcourse;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

// day 27 - 1 상자 쌓기
// https://school.programmers.co.kr/tryouts/207420/challenges?language=java
public class Day27_Queue {
	public static void main(String[] args) {
		int[] first_belt = {3, 4, 5, 6};
		int[] second_belt = {1, 2, 8, 9};
		int[] third_belt = {7, 10};
		int[] example = {5, 6, 7};

		// =========================================

		 LinkedList<Integer> first_list = Arrays.stream(first_belt)
			 .boxed()
			 .collect(Collectors.toCollection(LinkedList::new));
		LinkedList<Integer> second_list = Arrays.stream(second_belt)
			.boxed()
			.collect(Collectors.toCollection(LinkedList::new));
		LinkedList<Integer> third_list = Arrays.stream(third_belt)
			.boxed()
			.collect(Collectors.toCollection(LinkedList::new));

		int exampleP = 0;
		int beltP = 0;
		int count = 0;

		while(count < 4 && exampleP < example.length) {
			System.out.println("beltP = " + beltP);

			switch(beltP) {
				case 0:
					while(!first_list.isEmpty() && exampleP < example.length) {
						if (first_list.peekFirst().equals(example[exampleP])) {
							System.out.println("first_list.peekFirst(): " + first_list.peekFirst());
							first_list.pollFirst();
							exampleP++;
							count = 0;
						} else {
							count++;
							break;
						}
					}
					break;
				case 1:
					while(!second_list.isEmpty() && exampleP < example.length) {
						if (second_list.peekFirst().equals(example[exampleP])) {
							System.out.println("second_list.peekFirst(): " + second_list.peekFirst());
							second_list.pollFirst();
							exampleP++;
							count = 0;
						} else {
							count++;
							break;
						}
					}
					break;
				case 2:
					while(!third_list.isEmpty() && exampleP < example.length) {
						if (third_list.peekFirst().equals(example[exampleP])) {
							System.out.println("third_list.peekFirst(): " + third_list.peekFirst());
							third_list.pollFirst();
							exampleP++;
							count = 0;
						} else {
							count++;
							break;
						}
					}
					break;
			}

			beltP = (beltP + 1) % 3;
		}

		// System.out.println("exampleP = " + exampleP);

		if(exampleP == example.length) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
