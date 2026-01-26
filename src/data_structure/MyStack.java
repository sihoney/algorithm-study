package data_structure;

import java.util.NoSuchElementException;

class MyStack {
    private final int[] arr;
    private int top; // 다음에 들어갈 위치(=size)

    public MyStack(int capacity) {
        // TODO:  최대 크기 지정
        this.arr = new int[capacity];
    }

    public void push(int x) {
        // TODO: 스택에 x 추가 (가득 차면 IllegalStateException)
        if(top == arr.length) {
            throw new IllegalStateException();
        }

        arr[top] = x;

        top += 1;
    }

    public int pop() {
        // TODO: 맨 위 값 제거 후 반환 (비어있으면 NoSuchElementException)
        if(top == 0) throw new NoSuchElementException();

        int v = arr[top - 1];

        arr[top - 1] = 0;

        top -= 1;

        return v;
    }

    public int peek() {
        // TODO: 맨 위 값 반환 (비어있으면 NoSuchElementException)
        if(top == 0) throw new NoSuchElementException();

        int v = arr[top - 1];

        return v;
    }

    public boolean isEmpty() {
        // TODO
        if(top == 0) return true;

        return false;
    }

    public int size() {
        // TODO
        return top;
    }
}

