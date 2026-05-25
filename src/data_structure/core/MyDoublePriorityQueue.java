package data_structure.core;

import java.util.NoSuchElementException;
import java.util.TreeMap;

public class MyDoublePriorityQueue {
    private final TreeMap<Integer, Integer> counts = new TreeMap<>();
    private int size;

    public void offer(int value) {
        // TODO: value 개수 증가
        // if(isEmpty()) size = 0; // ❗필요 없습니다.

        counts.put(value, counts.getOrDefault(value, 0) + 1);

        size++;
    }

    public int pollMin() {
        // TODO: 최솟값 제거 후 반환
        if(isEmpty()) throw new NoSuchElementException();

        Integer min = counts.firstKey();
        decrease(min); // ❗동일 숫자가 2개 이상 존재 시, 하나만 삭제
        return min;

        // counts.remove(firstKey);
        // return firstKey;
    }

    public int pollMax() {
        // TODO: 최댓값 제거 후 반환
         if(isEmpty()) throw new NoSuchElementException();

        Integer max = counts.lastKey();
        decrease(max);
        return max;

        // counts.remove(lastKey);
        // return lastKey;
    }

    public int peekMin() {
        // TODO: 최솟값 반환
        if(isEmpty()) throw new NoSuchElementException(); // ❗ 빈 큐를 직접 검사하지 않습니다.

        return counts.firstKey();
    }

    public int peekMax() {
        // TODO: 최댓값 반환
        if(isEmpty()) throw new NoSuchElementException(); // ❗ 빈 큐를 직접 검사하지 않습니다.

        return counts.lastKey();
    }

    public boolean isEmpty() {
        // TODO
        return size == 0;
    }

    public int size() {
        // TODO
        return size;
    }

    private void decrease(int value) {
        // TODO: value 개수를 1 줄이고 0개가 되면 map에서 제거
        Integer count = counts.get(value);

        if(count == 1) {
            counts.remove(value);
        } else {
            counts.put(value, count - 1);
        }

        size--;

        // Integer replaced = counts.replace(value, counts.get(value) - 1);
        // if(replaced == 0) counts.remove(value);
    }
}
