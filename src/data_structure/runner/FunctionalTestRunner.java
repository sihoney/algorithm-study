package data_structure.runner;

import data_structure.functional.MyCollections;
import data_structure.functional.MyComparator;
import data_structure.functional.MyCollectors;
import data_structure.functional.MyStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static data_structure.runner.TestSupport.assertEquals;
import static data_structure.runner.TestSupport.assertThrows;
import static data_structure.runner.TestSupport.assertTrue;

public class FunctionalTestRunner {
    public static void main(String[] args) {
        testComparatorAndSort();
        testStreamIntermediateOperations();
        testCollectors();
        testStreamTerminalOperations();
        System.out.println("ALL FUNCTIONAL TESTS PASSED");
    }

    private static void testComparatorAndSort() {
        int[][] jobs = {
                {0, 3}, {1, 9}, {3, 5}, {1, 2}
        };

        MyComparator<int[]> byStartAscThenDurationDesc =
                MyComparator.comparingIntArrayIndex(0)
                        .thenComparing(MyComparator.comparingIntArrayIndex(1).reversed());

        MyCollections.sort(jobs, byStartAscThenDurationDesc);

        assertEquals(0, jobs[0][0], "jobs first start");
        assertEquals(1, jobs[1][0], "jobs second start");
        assertEquals(9, jobs[1][1], "same start should use duration desc first");
        assertEquals(2, jobs[2][1], "same start should use duration desc second");

        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 1, 3, 2, 4));
        MyCollections.sort(nums, MyComparator.naturalInt());
        assertEquals(1, nums.get(0), "list sort asc first");
        assertEquals(5, nums.get(4), "list sort asc last");

        MyCollections.sort(nums, MyComparator.reverseInt());
        assertEquals(5, nums.get(0), "list sort desc first");
        assertEquals(1, nums.get(4), "list sort desc last");

        int[] primitiveNums = {5, 1, 3, 2, 4};
        MyCollections.sort(primitiveNums);
        assertEquals(1, primitiveNums[0], "int[] sort asc first");
        assertEquals(5, primitiveNums[4], "int[] sort asc last");

        MyCollections.sort(primitiveNums, MyComparator.reverseInt());
        assertEquals(5, primitiveNums[0], "int[] sort desc first");
        assertEquals(1, primitiveNums[4], "int[] sort desc last");

        System.out.println("testComparatorAndSort passed");
    }

    private static void testStreamIntermediateOperations() {
        List<Integer> result = MyStream.of(Arrays.asList(5, 1, 4, 2, 3))
                .filter(n -> n % 2 == 1)
                .map(n -> n * 10)
                .sorted(MyComparator.reverseInt())
                .toList();

        assertEquals(50, result.get(0), "stream first");
        assertEquals(30, result.get(1), "stream second");
        assertEquals(10, result.get(2), "stream third");

        System.out.println("testStreamIntermediateOperations passed");
    }

    private static void testCollectors() {
        List<Integer> listResult = MyStream.of(Arrays.asList(5, 1, 3))
                .collect(MyCollectors.toList());

        assertEquals(3, listResult.size(), "collect toList size");
        assertEquals(5, listResult.get(0), "collect toList first");
        assertEquals(3, listResult.get(2), "collect toList last");

        Set<Integer> setResult = MyStream.of(Arrays.asList(5, 1, 5, 3, 1))
                .collect(MyCollectors.toSet());

        assertEquals(3, setResult.size(), "collect toSet size");
        assertTrue(setResult.contains(5), "collect toSet contains 5");
        assertTrue(setResult.contains(1), "collect toSet contains 1");
        assertTrue(setResult.contains(3), "collect toSet contains 3");

        String joined = MyStream.of(Arrays.asList("a", "b", "c"))
                .collect(MyCollectors.joining());
        assertEquals("abc", joined, "collect joining");

        String joinedWithDelimiter = MyStream.of(Arrays.asList("a", "b", "c"))
                .collect(MyCollectors.joining(","));
        assertEquals("a,b,c", joinedWithDelimiter, "collect joining delimiter");

        System.out.println("testCollectors passed");
    }

    private static void testStreamTerminalOperations() {
        int sum = MyStream.of(Arrays.asList(1, 2, 3, 4))
                .reduce(0, (acc, value) -> acc + value);
        assertEquals(10, sum, "reduce sum");

        int count = MyStream.of(Arrays.asList(1, 2, 3, 4))
                .count();
        assertEquals(4, count, "stream count");

        boolean hasEven = MyStream.of(Arrays.asList(1, 3, 4))
                .anyMatch(n -> n % 2 == 0);
        assertTrue(hasEven, "anyMatch even");

        boolean allPositive = MyStream.of(Arrays.asList(1, 2, 3))
                .allMatch(n -> n > 0);
        assertTrue(allPositive, "allMatch positive");

        boolean noneNegative = MyStream.of(Arrays.asList(1, 2, 3))
                .noneMatch(n -> n < 0);
        assertTrue(noneNegative, "noneMatch negative");

        int first = MyStream.of(Arrays.asList(7, 8, 9))
                .findFirst();
        assertEquals(7, first, "findFirst");

        assertThrows(NoSuchElementException.class, () -> MyStream.of(Arrays.asList()).findFirst(), "findFirst on empty stream");

        System.out.println("testStreamTerminalOperations passed");
    }
}
