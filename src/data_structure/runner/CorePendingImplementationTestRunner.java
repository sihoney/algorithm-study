package data_structure.runner;

import data_structure.core.MyDeque;
import data_structure.core.MyGraph;
import data_structure.core.MyHashMap;
import data_structure.core.MyHashSet;
import data_structure.core.MyTrie;
import data_structure.core.MyUnionFind;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static data_structure.runner.TestSupport.assertEquals;
import static data_structure.runner.TestSupport.assertFalse;
import static data_structure.runner.TestSupport.assertListEquals;
import static data_structure.runner.TestSupport.assertNull;
import static data_structure.runner.TestSupport.assertThrows;
import static data_structure.runner.TestSupport.assertTrue;

public class CorePendingImplementationTestRunner {
    public static void main(String[] args) {
        testMyHashSet();
        // testMyHashMap();
        // testMyGraph();
        // testMyUnionFind();
        // testMyDeque();
        // testMyTrie();
        System.out.println("ALL CORE PENDING IMPLEMENTATION TESTS PASSED");
    }

    private static void testMyHashSet() {
        MyHashSet<BadHashKey> set = new MyHashSet<>();

        BadHashKey one = new BadHashKey(1);
        BadHashKey two = new BadHashKey(2);
        BadHashKey sameAsOne = new BadHashKey(1);

        assertTrue(set.isEmpty(), "new hash set should be empty");
        assertEquals(0, set.size(), "new hash set size");
        assertFalse(set.contains(one), "hash set contains missing value");

        assertTrue(set.add(one), "hash set add first colliding value");
        assertTrue(set.add(two), "hash set add second colliding value");
        assertFalse(set.add(sameAsOne), "hash set reject duplicate equal value");
        assertEquals(2, set.size(), "hash set size after adds");
        assertTrue(set.contains(one), "hash set contains first value");
        assertTrue(set.contains(sameAsOne), "hash set contains equal value");
        assertTrue(set.contains(two), "hash set contains second value");

        assertTrue(set.add(null), "hash set add null");
        assertFalse(set.add(null), "hash set reject duplicate null");
        assertTrue(set.contains(null), "hash set contains null");

        assertTrue(set.remove(sameAsOne), "hash set remove equal value");
        assertFalse(set.contains(one), "hash set removed value should be absent");
        assertFalse(set.remove(one), "hash set remove missing value");
        assertTrue(set.remove(null), "hash set remove null");

        MyHashSet<Integer> resizedSet = new MyHashSet<>();

        for(int i = 0; i < 20; i++) {
            assertTrue(resizedSet.add(i), "hash set resize add " + i);
        }

        assertEquals(20, resizedSet.size(), "hash set size after resize");

        for(int i = 0; i < 20; i++) {
            assertTrue(resizedSet.contains(i), "hash set contains after resize " + i);
        }

        assertFalse(resizedSet.add(10), "hash set duplicate after resize");
        assertEquals(20, resizedSet.size(), "hash set size after duplicate following resize");
        assertTrue(resizedSet.remove(10), "hash set remove after resize");
        assertFalse(resizedSet.contains(10), "hash set removed value absent after resize");
        assertEquals(19, resizedSet.size(), "hash set size after remove following resize");

        System.out.println("testMyHashSet passed");
    }

    private static void testMyHashMap() {
        MyHashMap<BadHashKey, String> map = new MyHashMap<>();

        BadHashKey one = new BadHashKey(1);
        BadHashKey two = new BadHashKey(2);
        BadHashKey sameAsOne = new BadHashKey(1);

        assertTrue(map.isEmpty(), "new hash map should be empty");
        assertEquals(0, map.size(), "new hash map size");
        assertNull(map.get(one), "hash map get missing key");
        assertFalse(map.containsKey(one), "hash map contains missing key");

        assertNull(map.put(one, "one"), "hash map put first colliding key");
        assertNull(map.put(two, "two"), "hash map put second colliding key");
        assertEquals(2, map.size(), "hash map size after puts");
        assertEquals("one", map.get(sameAsOne), "hash map get equal key");
        assertEquals("two", map.get(two), "hash map get second key");
        assertTrue(map.containsKey(one), "hash map contains first key");

        assertEquals("one", map.put(sameAsOne, "ONE"), "hash map replace equal key");
        assertEquals(2, map.size(), "hash map size should not grow on replace");
        assertEquals("ONE", map.get(one), "hash map get replaced value");

        assertNull(map.put(null, "null-value"), "hash map put null key");
        assertEquals("null-value", map.get(null), "hash map get null key");
        assertTrue(map.containsKey(null), "hash map contains null key");

        assertEquals("two", map.remove(two), "hash map remove existing key");
        assertFalse(map.containsKey(two), "hash map removed key should be absent");
        assertNull(map.remove(two), "hash map remove missing key");

        System.out.println("testMyHashMap passed");
    }

    private static class BadHashKey {
        private final int value;

        BadHashKey(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(!(obj instanceof BadHashKey)) return false;

            BadHashKey other = (BadHashKey) obj;
            return value == other.value;
        }

        @Override
        public String toString() {
            return "BadHashKey{" + value + '}';
        }
    }

    private static void testMyDeque() {
        MyDeque<Integer> deque = new MyDeque<>(2);

        assertTrue(deque.isEmpty(), "new deque should be empty");
        assertEquals(0, deque.size(), "new deque size");
        assertThrows(NoSuchElementException.class, deque::peekFirst, "peekFirst on empty deque");
        assertThrows(NoSuchElementException.class, deque::peekLast, "peekLast on empty deque");
        assertThrows(NoSuchElementException.class, deque::pollFirst, "pollFirst on empty deque");
        assertThrows(NoSuchElementException.class, deque::pollLast, "pollLast on empty deque");

        deque.offerFirst(2);
        deque.offerFirst(1);
        deque.offerLast(3);

        assertEquals(3, deque.size(), "deque size after offers");
        assertEquals(1, deque.peekFirst(), "deque peekFirst");
        assertEquals(3, deque.peekLast(), "deque peekLast");
        assertEquals(1, deque.pollFirst(), "deque pollFirst");
        assertEquals(3, deque.pollLast(), "deque pollLast");
        assertEquals(2, deque.pollFirst(), "deque last value");
        assertTrue(deque.isEmpty(), "deque should be empty");

        System.out.println("testMyDeque passed");
    }

    private static void testMyGraph() {
        MyGraph graph = new MyGraph(4, false);

        assertEquals(4, graph.nodeCount(), "graph node count");
        assertEquals(0, graph.edgeCount(), "empty graph edge count");

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);

        assertEquals(3, graph.edgeCount(), "undirected graph edge count");
        assertListEquals(Arrays.asList(1, 2), graph.neighbors(0), "graph neighbors of 0");
        assertListEquals(Arrays.asList(0, 3), graph.neighbors(1), "graph neighbors of 1");
        assertListEquals(Arrays.asList(0, 1, 2, 3), graph.bfs(0), "graph bfs order");
        assertListEquals(Arrays.asList(0, 1, 3, 2), graph.dfs(0), "graph dfs order");
        assertThrows(IndexOutOfBoundsException.class, () -> graph.addEdge(-1, 0), "graph invalid from node");
        assertThrows(IndexOutOfBoundsException.class, () -> graph.neighbors(4), "graph invalid neighbors node");

        MyGraph directed = new MyGraph(3, true);
        directed.addEdge(0, 1);
        directed.addEdge(1, 0);
        directed.addEdge(1, 2);

        assertEquals(3, directed.edgeCount(), "directed graph edge count");
        assertListEquals(Arrays.asList(1), directed.neighbors(0), "directed graph neighbors of 0");
        assertListEquals(Arrays.asList(0, 2), directed.neighbors(1), "directed graph neighbors of 1");

        System.out.println("testMyGraph passed");
    }

    private static void testMyTrie() {
        MyTrie trie = new MyTrie();

        assertFalse(trie.contains("cat"), "trie contains missing word");
        assertFalse(trie.startsWith("ca"), "trie startsWith missing prefix");

        trie.insert("cat");
        trie.insert("car");
        trie.insert("dog");

        assertTrue(trie.contains("cat"), "trie contains cat");
        assertTrue(trie.contains("car"), "trie contains car");
        assertTrue(trie.contains("dog"), "trie contains dog");
        assertFalse(trie.contains("ca"), "trie prefix is not word");
        assertTrue(trie.startsWith("ca"), "trie startsWith ca");
        assertTrue(trie.startsWith("do"), "trie startsWith do");
        assertFalse(trie.startsWith("z"), "trie missing prefix");

        assertTrue(trie.remove("cat"), "trie remove existing word");
        assertFalse(trie.contains("cat"), "trie removed word should be absent");
        assertTrue(trie.contains("car"), "trie shared prefix word should remain");
        assertFalse(trie.remove("cat"), "trie remove missing word");
        assertThrows(IllegalArgumentException.class, () -> trie.insert("Cat"), "trie rejects uppercase");

        System.out.println("testMyTrie passed");
    }

    private static void testMyUnionFind() {
        MyUnionFind unionFind = new MyUnionFind(5);

        assertEquals(5, unionFind.componentCount(), "new union find component count");
        assertEquals(1, unionFind.sizeOf(0), "single node component size");
        assertFalse(unionFind.connected(0, 1), "new nodes should not be connected");

        assertTrue(unionFind.union(0, 1), "union different components");
        assertTrue(unionFind.connected(0, 1), "nodes should be connected after union");
        assertEquals(2, unionFind.sizeOf(0), "component size after union");
        assertEquals(4, unionFind.componentCount(), "component count after union");
        assertFalse(unionFind.union(0, 1), "union same component should return false");

        assertTrue(unionFind.union(1, 2), "union connected component with new node");
        assertTrue(unionFind.connected(0, 2), "transitive connection");
        assertEquals(3, unionFind.sizeOf(2), "component size after second union");
        assertEquals(3, unionFind.componentCount(), "component count after second union");

        assertThrows(IndexOutOfBoundsException.class, () -> unionFind.find(-1), "union find invalid negative index");
        assertThrows(IndexOutOfBoundsException.class, () -> unionFind.union(0, 5), "union find invalid upper index");

        System.out.println("testMyUnionFind passed");
    }
}
