package data_structure.runner;

import data_structure.functional.MyCollections;
import data_structure.functional.MyComparator;
import data_structure.functional.MyCollectors;
import data_structure.functional.MyStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		// 1. MyCollections.sort() - int[]
		// int[] jobs = {10, 1, 6, 4, 6, 2};
		//
		// System.out.println("Before sort");
		// print(jobs);
		//
		// MyCollections.sort(jobs, (a, b) -> Integer.compare(a, b));
		//
		// System.out.println("After sort by first value asc");
		// print(jobs);

		// 2. T[]
		// Integer[] jobs = {10, 1, 6, 4, 6, 2};
		//
		// System.out.println("Before sort");
		// print(jobs);
		//
		// MyCollections.sort(jobs, (a, b) -> Integer.compare(a, b));
		//
		// System.out.println("After sort by first value asc");
		// print(jobs);

		// 3. int[][]
		// int[][] jobs = {
		// 	{10, 1},
		// 	{6, 4},
		// 	{1, 2}
		// };
		//
		// System.out.println("Before sort");
		// print(jobs);
		//
		// MyCollections.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
		//
		// System.out.println("After sort by first value asc");
		// print(jobs);

		// 4. List<T>
		// List<Integer> jobs = Arrays.asList(1, 20, 43, 5);
		//
		// System.out.println("Before sort");
		// print(jobs);
		//
		// MyCollections.sort(jobs, (a, b) -> Integer.compare(a, b));
		//
		// System.out.println("After sort by first value asc");
		// print(jobs);

		// 1. MyStream.filter()
		// List<Integer> list = Arrays.asList(1, 4, 2, 6, 9, 3);
		//
		// System.out.println("Before filter");
		// print(list);
		//
		// List<Integer> result = MyStream.of(list)
		// 	.filter((x) -> x > 5)
		// 	.toList();
		//
		// System.out.println("After filter");
		// print(result);

		// 2. MyStream.map()
		// List<Integer> list = Arrays.asList(1, 4, 2, 6, 9, 3);
		//
		// System.out.println("Before map");
		// print(list);
		//
		// List<Integer> result = MyStream.of(list)
		// 	.map(x -> x * 10)
		// 	.toList();
		//
		// System.out.println("After map");
		// print(result);

		// 3. MyStream.sorted()
		// List<Integer> list = Arrays.asList(1, 4, 2, 6, 9, 3);
		//
		// System.out.println("Before sorted");
		// print(list);
		//
		// List<Integer> result = MyStream.of(list)
		// 	.sorted(MyComparator.naturalInt())
		// 	.toList();
		//
		// System.out.println("After sorted");
		// print(result);

		// 4. MyStream.collect(MyCollectors.toList())
		// List<Integer> list = Arrays.asList(1, 4, 2, 6, 9, 3);
		//
		// System.out.println("Before MyCollectors.toList()");
		// print(list);
		//
		// List<Integer> result = MyStream.of(list)
		// 	.sorted(MyComparator.naturalInt())
		// 	.collect(MyCollectors.toList());
		//
		// System.out.println("After MyCollectors.toList()");
		// print(result);

		// 5. MyStream.collect(MyCollectors.toSet())
		// List<Integer> list = Arrays.asList(1, 4, 2, 6, 9, 3);
		//
		// System.out.println("Before MyCollectors.toSet()");
		// print(list);
		//
		// Set<Integer> result = MyStream.of(list)
		// 	.sorted(MyComparator.naturalInt())
		// 	.collect(MyCollectors.toSet());
		//
		// System.out.println("After MyCollectors.toSet()");
		// System.out.println(result.toString());

		// 6. MyStream.collect(MyCollectors.joining())
		// List<String> list = Arrays.asList("korea", "japan", "US", "china");
		//
		// System.out.println("Before MyCollectors.joining()");
		// print(list);
		//
		// String result = MyStream.of(list)
		// 	.collect(MyCollectors.joining());
		//
		// System.out.println("After MyCollectors.joining()");
		// System.out.println(result);

		// 7. MyStream.collect(MyCollectors.joining(delimiter))
		// List<String> list = Arrays.asList("korea", "japan", "US", "china");
		//
		// System.out.println("Before MyCollectors.joining()");
		// print(list);
		//
		// String result = MyStream.of(list)
		// 	.collect(MyCollectors.joining(", "));
		//
		// System.out.println("After MyCollectors.joining()");
		// System.out.println(result);

		// 7. MyStream.reduce()
		// List<String> list = Arrays.asList("korea", "japan", "US", "china");
		//
		// System.out.println("Before MyStream.reduce()");
		// print(list);
		//
		// Integer result = MyStream.of(list)
		// 	.reduce(0, (accu, val) -> {
		// 		return accu + val.length();
		// });
		//
		// System.out.println("After MyStream.reduce()");
		// System.out.println(result);
	}

	private static void print(int[] arr) {
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	private static <T> void print(T[] arr) {
		for (T n : arr) {
			System.out.print(n.toString() + " ");
		}
		System.out.println();
	}

	private static void print(int[][] arr) {
		for (int[] n : arr) {
			System.out.print(Arrays.toString(n) + " ");
		}
		System.out.println();
	}

	private static <T> void print(List<T> arr) {
		for (T n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
