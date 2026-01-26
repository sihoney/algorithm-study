package data_structure;

import java.util.NoSuchElementException;

/**
 * 사용법:
 * 1) MyStack / MyQueue / MyLinkedList 구현을 너희 코드로 채운다.
 * 2) main 실행
 *
 * - JUnit 없이도 동작
 * - 값 검증 + 예외(IllegalStateException, NoSuchElementException, IndexOutOfBoundsException) 검증 포함
 */
public class DataStructureTemplateTestRunner {

    public static void main(String[] args) {
        try {
            testMyStack();
            testMyQueue();
            testMyLinkedList();
            System.out.println("\n✅ ALL TESTS PASSED");
        } catch (AssertionError e) {
            System.out.println("\n❌ TEST FAILED: " + e.getMessage());
            throw e;
        }
    }

    // -----------------------
    // 1) MyStack tests
    // -----------------------
    private static void testMyStack() {
        System.out.println("== MyStack tests ==");

        MyStack s = new MyStack(2);
        assertTrue(s.isEmpty(), "new stack should be empty");
        assertEquals(0, s.size(), "new stack size");

        // empty pop/peek
        assertThrows(NoSuchElementException.class, s::pop, "pop on empty should throw");
        assertThrows(NoSuchElementException.class, s::peek, "peek on empty should throw");

        // push/peek/pop
        s.push(1);
        assertFalse(s.isEmpty(), "after push, stack not empty");
        assertEquals(1, s.size(), "size after push 1");
        assertEquals(1, s.peek(), "peek should be 1");
        assertEquals(1, s.size(), "size unchanged after peek");

        s.push(2);
        assertEquals(2, s.size(), "size after push 2");
        assertEquals(2, s.peek(), "peek should be 2");
        assertEquals(2, s.pop(), "pop should be 2");
        assertEquals(1, s.size(), "size after pop");
        assertEquals(1, s.pop(), "pop should be 1");
        assertTrue(s.isEmpty(), "stack should be empty again");

        // overflow
        s.push(10);
        s.push(20);
        assertThrows(IllegalStateException.class, () -> s.push(30), "push on full should throw");

        System.out.println("✅ MyStack OK");
    }

    // -----------------------
    // 2) MyQueue tests
    // -----------------------
     private static void testMyQueue() {
         System.out.println("== MyQueue tests ==");

         MyQueue q = new MyQueue(3);
         assertTrue(q.isEmpty(), "new queue should be empty");
         assertEquals(0, q.size(), "new queue size");

         // empty poll/peek
         assertThrows(NoSuchElementException.class, q::poll, "poll on empty should throw");
         assertThrows(NoSuchElementException.class, q::peek, "peek on empty should throw");

         // basic flow
         q.offer(1);
         q.offer(2);
         assertEquals(2, q.size(), "size after offers");
         assertEquals(1, q.peek(), "peek should be 1");
         assertEquals(1, q.poll(), "poll should be 1");
         assertEquals(1, q.size(), "size after poll");
         q.offer(3);
         assertEquals(2, q.size(), "size after offer 3");
         assertEquals(2, q.poll(), "poll should be 2");
         assertEquals(3, q.poll(), "poll should be 3");
         assertTrue(q.isEmpty(), "queue should be empty again");

         // circular behavior check (rear wraps)
         q.offer(10);
         q.offer(20);
         q.offer(30);
         assertThrows(IllegalStateException.class, () -> q.offer(40), "offer on full should throw");
         assertEquals(10, q.poll(), "poll should be 10");
         q.offer(40); // should go into wrapped slot
         assertEquals(20, q.poll(), "poll should be 20");
         assertEquals(30, q.poll(), "poll should be 30");
         assertEquals(40, q.poll(), "poll should be 40");
         assertTrue(q.isEmpty(), "queue should be empty at end");

         System.out.println("✅ MyQueue OK");
     }

    // -----------------------
    // 3) MyLinkedList tests
    // -----------------------
    private static void testMyLinkedList() {
        System.out.println("== MyLinkedList tests ==");

        MyLinkedList list = new MyLinkedList();
        assertEquals(0, list.size(), "new list size");

        // remove on empty
        assertThrows(NoSuchElementException.class, list::removeFirst, "removeFirst on empty should throw");
        assertThrows(NoSuchElementException.class, list::removeLast, "removeLast on empty should throw");

        // addFirst / addLast
        list.addFirst(2); // [2]
        assertEquals(1, list.size(), "size after addFirst");
        assertEquals(2, list.get(0), "get(0)");

        list.addFirst(1); // [1,2]
        list.addLast(3);  // [1,2,3]
        assertEquals(3, list.size(), "size after adds");
        assertEquals(1, list.get(0), "get(0)");
        assertEquals(2, list.get(1), "get(1)");
        assertEquals(3, list.get(2), "get(2)");

        // get out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1), "get(-1) should throw");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3), "get(3) should throw");

        // removeFirst
        assertEquals(1, list.removeFirst(), "removeFirst should return 1"); // [2,3]
        assertEquals(2, list.size(), "size after removeFirst");
        assertEquals(2, list.get(0), "get(0) after removeFirst");

        // removeLast
        assertEquals(3, list.removeLast(), "removeLast should return 3"); // [2]
        assertEquals(1, list.size(), "size after removeLast");
        assertEquals(2, list.get(0), "single element check");

        // removeLast on single element should update head/tail properly
        assertEquals(2, list.removeLast(), "removeLast on single should return 2"); // []
        assertEquals(0, list.size(), "size after removing last element");
        assertThrows(NoSuchElementException.class, list::removeFirst, "removeFirst on empty again should throw");
        assertThrows(NoSuchElementException.class, list::removeLast, "removeLast on empty again should throw");

        // mixed operations
        list.addLast(10); // [10]
        list.addLast(20); // [10,20]
        list.addFirst(5); // [5,10,20]
        assertEquals(3, list.size(), "size after mixed add");
        assertEquals(20, list.removeLast(), "removeLast should return 20"); // [5,10]
        assertEquals(5, list.removeFirst(), "removeFirst should return 5"); // [10]
        assertEquals(10, list.get(0), "remaining element should be 10");

        System.out.println("✅ MyLinkedList OK");
    }

    // -----------------------
    // Minimal assertion helpers
    // -----------------------
    private static void assertEquals(int expected, int actual, String msg) {
        if (expected != actual) {
            throw new AssertionError(msg + " | expected=" + expected + " actual=" + actual);
        }
    }

    private static void assertTrue(boolean cond, String msg) {
        if (!cond) throw new AssertionError(msg + " | expected=true actual=false");
    }

    private static void assertFalse(boolean cond, String msg) {
        if (cond) throw new AssertionError(msg + " | expected=false actual=true");
    }

    @FunctionalInterface
    private interface ThrowingRunnable {
        void run();
    }

    private static void assertThrows(Class<? extends Throwable> expected, ThrowingRunnable r, String msg) {
        try {
            r.run();
        } catch (Throwable t) {
            if (expected.isInstance(t)) return;
            throw new AssertionError(msg + " | expected exception=" + expected.getSimpleName()
                    + " actual=" + t.getClass().getSimpleName(), t);
        }
        throw new AssertionError(msg + " | expected exception=" + expected.getSimpleName() + " but none thrown");
    }
}
