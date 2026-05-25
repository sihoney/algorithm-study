package data_structure.runner;

import java.util.List;

final class TestSupport {
    private TestSupport() {
    }

    static void assertEquals(int expected, int actual, String msg) {
        if(expected != actual) {
            throw new AssertionError(msg + " | expected=" + expected + " actual=" + actual);
        }
    }

    static void assertEquals(String expected, String actual, String msg) {
        if(!expected.equals(actual)) {
            throw new AssertionError(msg + " | expected=" + expected + " actual=" + actual);
        }
    }

    static void assertListEquals(List<?> expected, List<?> actual, String msg) {
        if(!expected.equals(actual)) {
            throw new AssertionError(msg + " | expected=" + expected + " actual=" + actual);
        }
    }

    static void assertTrue(boolean condition, String msg) {
        if(!condition) {
            throw new AssertionError(msg + " | expected=true actual=false");
        }
    }

    static void assertFalse(boolean condition, String msg) {
        if(condition) {
            throw new AssertionError(msg + " | expected=false actual=true");
        }
    }

    static void assertNull(Object actual, String msg) {
        if(actual != null) {
            throw new AssertionError(msg + " | expected=null actual=" + actual);
        }
    }

    static void assertThrows(Class<? extends Throwable> expected, ThrowingRunnable runnable, String msg) {
        try {
            runnable.run();
        } catch(Throwable actual) {
            if(expected.isInstance(actual)) return;
            throw new AssertionError(msg + " | expected=" + expected.getSimpleName()
                    + " actual=" + actual.getClass().getSimpleName(), actual);
        }

        throw new AssertionError(msg + " | expected=" + expected.getSimpleName() + " but none thrown");
    }

    @FunctionalInterface
    interface ThrowingRunnable {
        void run();
    }
}
