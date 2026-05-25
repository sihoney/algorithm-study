package data_structure.runner;

import data_structure.core.MyDoublePriorityQueue;
import data_structure.core.MyLinkedList;
import data_structure.core.MyPriorityQueue;
import data_structure.core.MyQueue;
import data_structure.core.MyStack;
import data_structure.core.MyTreeMap;
import data_structure.functional.MyComparator;

import java.util.NoSuchElementException;

import static data_structure.runner.TestSupport.assertEquals;
import static data_structure.runner.TestSupport.assertFalse;
import static data_structure.runner.TestSupport.assertNull;
import static data_structure.runner.TestSupport.assertThrows;
import static data_structure.runner.TestSupport.assertTrue;

public class CoreImplementedTestRunner {
    public static void main(String[] args) {
        testMyStack();
        testMyQueue();
        testMyLinkedList();
        testMyPriorityQueue();
        testMyDoublePriorityQueue();
        testMyTreeMap();
        System.out.println("ALL CORE IMPLEMENTED TESTS PASSED");
    }

    private static void testMyStack() {
        MyStack stack = new MyStack(2);

        assertTrue(stack.isEmpty(), "new stack should be empty");
        assertEquals(0, stack.size(), "new stack size");
        assertThrows(NoSuchElementException.class, stack::pop, "pop on empty stack");
        assertThrows(NoSuchElementException.class, stack::peek, "peek on empty stack");

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.size(), "stack size after pushes");
        assertEquals(2, stack.peek(), "stack peek");
        assertThrows(IllegalStateException.class, () -> stack.push(3), "push on full stack");
        assertEquals(2, stack.pop(), "stack pop first");
        assertEquals(1, stack.pop(), "stack pop second");
        assertTrue(stack.isEmpty(), "stack should be empty after pops");

        System.out.println("testMyStack passed");
    }

    private static void testMyQueue() {
        MyQueue queue = new MyQueue(3);

        assertTrue(queue.isEmpty(), "new queue should be empty");
        assertEquals(0, queue.size(), "new queue size");
        assertThrows(NoSuchElementException.class, queue::poll, "poll on empty queue");
        assertThrows(NoSuchElementException.class, queue::peek, "peek on empty queue");

        queue.offer(1);
        queue.offer(2);
        assertEquals(1, queue.peek(), "queue peek");
        assertEquals(1, queue.poll(), "queue poll first");
        queue.offer(3);
        queue.offer(4);
        assertThrows(IllegalStateException.class, () -> queue.offer(5), "offer on full queue");
        assertEquals(2, queue.poll(), "queue poll second");
        assertEquals(3, queue.poll(), "queue poll third");
        assertEquals(4, queue.poll(), "queue poll wrapped value");
        assertTrue(queue.isEmpty(), "queue should be empty after polls");

        System.out.println("testMyQueue passed");
    }

    private static void testMyLinkedList() {
        MyLinkedList list = new MyLinkedList();

        assertEquals(0, list.size(), "new linked list size");
        assertThrows(NoSuchElementException.class, list::removeFirst, "removeFirst on empty list");
        assertThrows(NoSuchElementException.class, list::removeLast, "removeLast on empty list");

        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);

        assertEquals(3, list.size(), "linked list size after adds");
        assertEquals(1, list.get(0), "linked list get first");
        assertEquals(2, list.get(1), "linked list get middle");
        assertEquals(3, list.get(2), "linked list get last");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1), "linked list get negative index");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3), "linked list get size index");

        assertEquals(1, list.removeFirst(), "linked list removeFirst");
        assertEquals(3, list.removeLast(), "linked list removeLast");
        assertEquals(2, list.removeLast(), "linked list removeLast single");
        assertEquals(0, list.size(), "linked list size after removals");

        System.out.println("testMyLinkedList passed");
    }

    private static void testMyPriorityQueue() {
        MyPriorityQueue<Integer> minQueue = new MyPriorityQueue<>(MyComparator.naturalInt());

        assertTrue(minQueue.isEmpty(), "new priority queue should be empty");
        assertEquals(0, minQueue.size(), "new priority queue size");
        assertThrows(NoSuchElementException.class, minQueue::peek, "peek on empty priority queue");
        assertThrows(NoSuchElementException.class, minQueue::poll, "poll on empty priority queue");

        minQueue.offer(5);
        minQueue.offer(1);
        minQueue.offer(3);
        minQueue.offer(1);

        assertEquals(1, minQueue.peek(), "priority queue peek min");
        assertEquals(1, minQueue.poll(), "priority queue poll first min");
        assertEquals(1, minQueue.poll(), "priority queue poll duplicate min");
        assertEquals(3, minQueue.poll(), "priority queue poll next");
        assertEquals(5, minQueue.poll(), "priority queue poll last");
        assertTrue(minQueue.isEmpty(), "priority queue should be empty");

        MyPriorityQueue<Integer> maxQueue = new MyPriorityQueue<>(MyComparator.reverseInt());
        maxQueue.offer(5);
        maxQueue.offer(1);
        maxQueue.offer(3);

        assertEquals(5, maxQueue.poll(), "reverse comparator poll max first");
        assertEquals(3, maxQueue.poll(), "reverse comparator poll max second");
        assertEquals(1, maxQueue.poll(), "reverse comparator poll max third");

        System.out.println("testMyPriorityQueue passed");
    }

    private static void testMyDoublePriorityQueue() {
        MyDoublePriorityQueue queue = new MyDoublePriorityQueue();

        assertTrue(queue.isEmpty(), "new double priority queue should be empty");
        assertEquals(0, queue.size(), "new double priority queue size");
        assertThrows(NoSuchElementException.class, queue::pollMin, "pollMin on empty queue");
        assertThrows(NoSuchElementException.class, queue::pollMax, "pollMax on empty queue");
        assertThrows(NoSuchElementException.class, queue::peekMin, "peekMin on empty queue");
        assertThrows(NoSuchElementException.class, queue::peekMax, "peekMax on empty queue");

        queue.offer(5);
        queue.offer(1);
        queue.offer(5);
        queue.offer(3);
        queue.offer(7);
        queue.offer(1);

        assertEquals(6, queue.size(), "double priority queue size after offers");
        assertEquals(1, queue.peekMin(), "double priority queue peekMin");
        assertEquals(7, queue.peekMax(), "double priority queue peekMax");
        assertEquals(1, queue.pollMin(), "double priority queue pollMin first duplicate");
        assertEquals(1, queue.pollMin(), "double priority queue pollMin second duplicate");
        assertEquals(7, queue.pollMax(), "double priority queue pollMax max");
        assertEquals(5, queue.pollMax(), "double priority queue pollMax first 5");
        assertEquals(5, queue.peekMax(), "double priority queue duplicate max remains");
        assertEquals(5, queue.pollMax(), "double priority queue pollMax second 5");
        assertEquals(3, queue.pollMin(), "double priority queue last value");
        assertTrue(queue.isEmpty(), "double priority queue should be empty");

        System.out.println("testMyDoublePriorityQueue passed");
    }

    private static void testMyTreeMap() {
        MyTreeMap<Integer, String> map = new MyTreeMap<>(MyComparator.naturalInt());

        assertTrue(map.isEmpty(), "new map should be empty");
        assertEquals(0, map.size(), "new map size");
        assertThrows(NoSuchElementException.class, map::firstKey, "firstKey on empty map");
        assertThrows(NoSuchElementException.class, map::lastKey, "lastKey on empty map");

        assertNull(map.put(5, "five"), "put 5");
        assertNull(map.put(3, "three"), "put 3");
        assertNull(map.put(7, "seven"), "put 7");
        assertNull(map.put(2, "two"), "put 2");
        assertNull(map.put(4, "four"), "put 4");
        assertNull(map.put(6, "six"), "put 6");
        assertNull(map.put(8, "eight"), "put 8");

        assertEquals(7, map.size(), "map size after puts");
        assertEquals("four", map.get(4), "map get existing key");
        assertNull(map.get(100), "map get missing key");
        assertTrue(map.containsKey(6), "map contains existing key");
        assertFalse(map.containsKey(100), "map contains missing key");
        assertEquals(2, map.firstKey(), "map firstKey");
        assertEquals(8, map.lastKey(), "map lastKey");

        assertEquals("three", map.put(3, "THREE"), "map replace existing key");
        assertEquals("THREE", map.get(3), "map get replaced value");
        assertEquals(7, map.size(), "map size should not grow on replace");

        assertEquals("two", map.remove(2), "map remove leaf");
        assertFalse(map.containsKey(2), "map leaf should be removed");
        assertEquals("five", map.remove(5), "map remove node with two children");
        assertFalse(map.containsKey(5), "map removed key should be absent");
        assertEquals("six", map.get(6), "map successor remains");
        assertEquals(5, map.size(), "map size after removes");
        assertNull(map.remove(100), "map remove missing key");

        System.out.println("testMyTreeMap passed");
    }
}
