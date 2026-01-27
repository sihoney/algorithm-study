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
        newNode.next = head;

        head = newNode;
        if(size == 0) tail = newNode;

        size++;
    }

    public void addLast(int x) {
        // TODO
        Node newNode = new Node(x);
        tail.next = newNode;

        tail = newNode;
        if(size == 0) head = newNode;

        size++;
    }

    public int removeFirst() {
        // TODO: 없으면 NoSuchElementException
        if(size == 0) throw new NoSuchElementException();

        Node currNode = head;

        head = head.next;

        size--;

        return currNode.val;
    }

    public int removeLast() {
        // TODO: 없으면 NoSuchElementException
        if(size == 0) throw new NoSuchElementException();

        Node tailRemoved = tail;

        Node node = head;
        for(int i = 1; i < size - 1; i++) {
            node = node.next;
        }
        tail = node;

        size--;

        return tailRemoved.val;
    }

    public int get(int index) {
        // TODO: 범위 밖이면 IndexOutOfBoundsException
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node target = head;
        for(int idx = 0; idx < index; idx++) {
            target = target.next;
        }

        return target.val;
    }

    public int size() {
        // TODO
        return size;
    }
}
