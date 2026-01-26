package data_structure;

import java.util.NoSuchElementException;

/**
 * front, rear, size를 사용해서 원형으로 관리
 * 인덱스 이동은 (index + 1) % capacity
 */

class MyQueue {
    private final int[] arr;
    private int front; // 현재 맨 앞 원소 위치
    private int rear;  // 다음에 삽입할 위치
    private int size;

    public MyQueue(int capacity) {
        // TODO
        this.arr = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public void offer(int x) {
        // TODO: 뒤에 삽입 (가득 차면 IllegalStateException)
        if(size == arr.length) throw new IllegalStateException();

        arr[rear] = x;

        rear = (rear + 1) % arr.length; // 인덱스 이동은 (index + 1) % capacity
        size += 1;
    }

    public int poll() {
        // TODO: 앞에서 제거 후 반환 (비어있으면 NoSuchElementException)
        if(size == 0) throw new NoSuchElementException();

        int v = arr[front];

        arr[front] = 0;

        front = (front + 1) % arr.length; // 인덱스 이동은 (index + 1) % capacity
        size -= 1;

        return v;
    }

    public int peek() {
        // TODO: 앞의 값 반환 (비어있으면 NoSuchElementException)
        if(size == 0) throw new NoSuchElementException();

        int v = arr[front];

        return v;
    }

    public boolean isEmpty() {
        // TODO
        if(size == 0) return true;

        return false;
    }

    public int size() {
        // TODO
        return size;
    }
}
