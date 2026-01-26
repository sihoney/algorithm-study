package data_structure;

import java.util.NoSuchElementException;

/**
 * <구현 포인트>
 * head, tail, size 필드 사용
 * removeLast()는 단일 연결 리스트라면 이전 노드를 찾기 위해 순회 필요 (이거 말로 설명하면 점수 잘 나옴)
 */

class MyLinkedList {
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int x) {
        // TODO
        Node newNode = new Node(x);
        newNode.next = head; // Q. next에 접근 어떻게 해?

        head = newNode;
        if(size == 0) tail = newNode;

        size++;
    }

    public void addLast(int x) {
        // TODO
        Node newNode = new Node(x);
        tail.next = newNode;

        Node tail = newNode;

        size++;
    }

    public int removeFirst() {
        // TODO: 없으면 NoSuchElementException
        if(size == 0) throw new NoSuchElementException();

        Node nextNode = head.next;

        head = nextNode;

        size--;

        return -1;
    }

    public int removeLast() {
        // TODO: 없으면 NoSuchElementException
        if(size == 0) throw new NoSuchElementException();



        return -1;
    }

    public int get(int index) {
        // TODO: 범위 밖이면 IndexOutOfBoundsException


        return -1;
    }

    public int size() {
        // TODO
        return size;
    }
}
