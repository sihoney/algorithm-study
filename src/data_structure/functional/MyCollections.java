package data_structure.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * public sort(...)         : 사용자가 호출하는 입구
 * private mergeSort(...)   : 실제 재귀 정렬
 * private merge(...)       : 정렬된 두 구간을 합침
 *
 * - public 함수는 private 함수에 전체 범위를 넘기는 역할
 * - 즉, 핵심은 private에 있고, public은 사용하기 쉽게 감싼 wrapper
 */
public class MyCollections {
    private MyCollections() {
    }

    public static <T> void sort(List<T> list, MyComparator<T> comparator) {
        // TODO: list 전체 정렬
        mergeSort(list, 0, list.size(), comparator);
    }

    public static <T> void sort(T[] arr, MyComparator<T> comparator) {
        // TODO: 객체 배열 전체 정렬
        mergeSort(arr, 0, arr.length, comparator);
    }

    public static void sort(int[] arr) {
        sort(arr, (a, b) -> Integer.compare(a, b));
    }

    public static void sort(int[] arr, MyComparator<Integer> comparator) {
        mergeSort(arr, 0, arr.length, comparator);
    }

    public static void sort(int[][] arr, MyComparator<int[]> comparator) {
        // 의미:
        // public sort는 사용자가 호출하는 입구다.
        // 실제 정렬은 private mergeSort가 담당하므로 전체 범위 [0, arr.length)를 넘긴다.
        // TODO: int[][] 전체 정렬
        mergeSort(arr, 0, arr.length, comparator);
    }

    private static <T> void mergeSort(List<T> list, int left, int right, MyComparator<T> comparator) {
        // TODO: List용 merge sort 구현
        if(right - left <= 1) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(list, left, mid, comparator);
        mergeSort(list, mid, right, comparator);

        merge(list, left, mid, right, comparator);
    }

    private static <T> void merge(List<T> list, int left, int mid, int right, MyComparator<T> comparator) {
        // TODO: List용 병합 구현
        List<T> temp = new ArrayList<>();

        int i = left;
        int j = mid;

        while(i < mid && j < right) {
            if(comparator.compare(list.get(i), list.get(j)) <= 0) { // 💡 비교대상이 잘못됐습니다. (left/right -> i/j)
                temp.add(list.get(i++));
            } else {
                temp.add(list.get(j++));
            }
        }

        while(i < mid) temp.add(list.get(i++));
        while(j < right) temp.add(list.get(j++));

        for(int a = 0; a < temp.size(); a++) {
            list.set(left + a, temp.get(a)); // 💡 merge sort에서는 원본 리스트의 크기를 늘리면 안 됩니다. (add -> set)
        }
    }

    private static <T> void mergeSort(T[] arr, int left, int right, MyComparator<T> comparator) {
        // TODO: 객체 배열용 merge sort 구현
        if(right - left <= 1) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, comparator);
        mergeSort(arr, mid, right, comparator);

        merge(arr, left, mid, right, comparator);
    }

    private static <T> void merge(T[] arr, int left, int mid, int right, MyComparator<T> comparator) {
        // TODO: 객체 배열용 병합 구현
        // Object[] temp = new Object[right - left];
        T[] temp = Arrays.copyOfRange(arr, left, right);
        // copyOfRange 사용 목적: 타입이 맞는 임시 배열을 얻기 위해 O, 복사본을 만들려고 X

        int i = left;
        int j = mid;
        int k = 0;

        while(i < mid && j < right) {
            if(comparator.compare(arr[i], arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i < mid) temp[k++] = arr[i++];
        while(j < right) temp[k++] = arr[j++];

        for(int idx = 0; idx < temp.length; idx++) {
            // arr[left + idx] = (T) temp[idx];
            arr[left + idx] = temp[idx];
        }
    }

    private static void mergeSort(int[] arr, int left, int right, MyComparator<Integer> comparator) {
        if (right - left <= 1) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, comparator);
        mergeSort(arr, mid, right, comparator);

        merge(arr, left, mid, right, comparator);
    }

    private static void merge(int[] arr, int left, int mid, int right, MyComparator<Integer> comparator) {
        int[] temp = new int[right - left];
        int i = left;
        int j = mid;
        int k = 0;

        while (i < mid && j < right) {
            if (comparator.compare(arr[i], arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j < right) {
            temp[k++] = arr[j++];
        }

        for (int idx = 0; idx < temp.length; idx++) {
            arr[left + idx] = temp[idx];
        }
    }

    private static void mergeSort(int[][] arr, int left, int right, MyComparator<int[]> comparator) {
        // 의미:
        // [left, right) 구간의 길이가 1 이하이면 이미 정렬된 상태다.
        // 왼쪽 [left, mid), 오른쪽 [mid, right)를 각각 정렬한 뒤 merge로 합친다.
        // TODO: int[][]용 merge sort 구현
        if(right - left <= 1) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, comparator);
        mergeSort(arr, mid, right, comparator);

        merge(arr, left, mid, right, comparator);
    }

    // merge(): 이미 정렬된 두 구간을 하나의 정렬된 구간으로 합치는 함수
    private static void merge(int[][] arr, int left, int mid, int right, MyComparator<int[]> comparator) {
        // 의미:
        // [left, mid], [mid, right] 두 구간은 이미 정렬되어 있다고 가정한다.
        // comparator.compare(arr[i], arr[j]) <= 0 이면 arr[i]가 앞에 와야 하므로 temp에 먼저 넣는다.
        // 한쪽 구간을 다 쓰면 남은 원소를 그대로 temp에 넣고, 마지막에 arr로 복사한다.
        // TODO: int[][]용 병합 구현

        int[][] temp = new int[right - left][];

        int i = left;
        int j = mid;
        int k = 0;

        while(i < mid && j < right) {
            if(comparator.compare(arr[i], arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i < mid) temp[k++] = arr[i++];
        while(j < right) temp[k++] = arr[j++];

        for(int idx = 0; idx < temp.length; idx++) {
            arr[left + idx] = temp[idx];
        }
    }
}
