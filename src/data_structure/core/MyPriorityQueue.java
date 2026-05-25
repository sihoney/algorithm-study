package data_structure.core;

import data_structure.functional.MyComparator;

import java.util.NoSuchElementException;

public class MyPriorityQueue<T> {
    private Object[] heap;
    private int size;
    private final MyComparator<T> comparator;

    public MyPriorityQueue(MyComparator<T> comparator) {
        this(16, comparator);
    }

    public MyPriorityQueue(int capacity, MyComparator<T> comparator) {
        this.heap = new Object[Math.max(1, capacity)];
        this.comparator = comparator;
    }

    public void offer(T value) {
        // TODO: heap 끝에 추가한 뒤 위로 올리기
        ensureCapacity();

        heap[size] = value;
        size++;
        siftUp(size - 1);
    }

    public T poll() {
        // TODO: 루트 값을 제거하고 마지막 값을 루트로 옮긴 뒤 아래로 내리기
        if(isEmpty()) throw new NoSuchElementException();

        T polled = elementAt(0);

        // 루트 값 제거 & 마지막 값을 루트로 옮김
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        // 아래로 내리기
        if(!isEmpty()) {
            siftDown(0);
        }

        return polled;
    }

    public T peek() {
        // TODO: 루트 값 반환
        if(isEmpty()) throw new NoSuchElementException();

        return elementAt(0);
    }

    public boolean isEmpty() {
        // TODO
        return size == 0;
    }

    public int size() {
        // TODO
        return size;
    }

    private void siftUp(int index) {
        // TODO: 부모와 비교하며 heap 조건 복구
        int parentIdx;

        while(index > 0) {
            parentIdx = (index - 1) / 2; // ❗연산자 우선 순위

            if(compare(index, parentIdx) >= 0) { // ❗부모보다 작은 경우, 반복문 중지
                break;
            }

            swap(index, parentIdx);
            index = parentIdx;
        }
    }

    private void siftDown(int index) {
        // TODO: 자식과 비교하며 heap 조건 복구
        while(true) { // ❗'index < size' 조건만으로는 부족
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int best = index;

            if(left < size && compare(left, best) < 0) {
                best = left;
            }

            if(right < size && compare(right, best) < 0) {
                best = right;
            }

            if(best == index) {
                break;
            }

            swap(index, best);
            index = best;
        }
    }

    private int compare(int i, int j) {
        // TODO: heap[i]와 heap[j] 비교
        return comparator.compare(elementAt(i), elementAt(j));
    }

    private void swap(int i, int j) {
        // TODO: heap[i], heap[j] 교환
        T elementI = elementAt(i);
        T elementJ = elementAt(j);

        heap[i] = elementJ;
        heap[j] = elementI;
    }

    private void ensureCapacity() {
        // TODO: 배열이 가득 찼으면 2배로 확장
        if(heap.length == size) {
            Object[] temp = new Object[size * 2];

            for(int i = 0; i < heap.length; i++) {
                temp[i] = heap[i];
            }

            heap = temp;
        }
    }

    @SuppressWarnings("unchecked")
    private T elementAt(int index) {
        // TODO: Object 배열 값을 T로 캐스팅해서 반환
        return (T) heap[index];
    }
}
