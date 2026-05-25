package data_structure.core;

import java.util.NoSuchElementException;

import data_structure.functional.MyComparator;

/**
 * TreeMap 간단 버전 학습용 템플릿입니다.
 *
 * 균형 트리까지 구현하지 않고, 먼저 이진 탐색 트리(BST)로 key 정렬 구조를 이해합니다.
 */
public class MyTreeMap<K, V> {
    private Node<K, V> root;
    private int size;
    private final MyComparator<K> comparator;

    public MyTreeMap(MyComparator<K> comparator) {
        this.comparator = comparator;
    }

    public V put(K key, V value) {
        // TODO: key가 없으면 추가하고 null 반환, 있으면 value 교체 후 old value 반환
        if(root == null) {
            root = new Node<>(key, value);
            size++;
            return null;
        }

        Node<K, V> current = root;

        while(true) {
            int cmp = compare(key, current.key);

            if(cmp == 0) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }

            if(cmp < 0) {
                if(current.left == null) {
                    current.left = new Node<>(key, value);
                    size++;
                    return null;
                }

                current = current.left;
            } else {
                if(current.right == null) {
                    current.right = new Node<>(key, value);
                    size++;
                    return null;
                }

                current = current.right;
            }
        }
    }

    public V get(K key) {
        // TODO: key에 해당하는 value 반환, 없으면 null 반환
        Node<K, V> node = findNode(key);
        return node == null ? null : node.value;
    }

    public boolean containsKey(K key) {
        // TODO: key가 존재하면 true 반환
        return findNode(key) != null;
    }

    public V remove(K key) {
        // TODO: key가 존재하면 제거하고 old value 반환, 없으면 null 반환
        Node<K, V> current = root;
        Node<K, V> parent = null; // ❗ parent를 찾고 있지만 삭제 시 사용하지 않습니다.

        while(current != null) { // ❗ 'current == null' 체크가 없습니다.
            int cmp = compare(key, current.key); // ❗ 비교 방향과 이동 방향이 맞지 않습니다.

            if(cmp == 0) {
                V oldValue = current.value;
                removeNode(parent, current);
                // if(current.left == null && current.right == null) {
                //     current = null; // ❗current만 바꾸고 있어서 실제 트리 연결이 바뀌지 않습니다.
                // } else if(current.left == null) {
                //     current = current.right;
                // } else if(current.right == null) {
                //     current = current.left;
                // } else {
                //     K minKey = firstKey(); // ❗firstKey()는 전체 트리의 최솟값입니다.
                //
                //     current = findNode(minKey); // ❗ 삭제 처리가 아닙니다.
                // }
                size--; // ❗삭제 성공 시 size--가 없습니다.
                return oldValue;
            }

            parent = current;
            current = cmp < 0 ? current.left : current.right;
        }

        return null;
    }

    public K firstKey() {
        // TODO: 가장 작은 key 반환. 비어 있으면 NoSuchElementException
        if(isEmpty()) throw new NoSuchElementException();

        Node<K, V> current = root;
        // K min = current.key; // ❗필요 X

        while(current.left != null) {
            // if(compare(current.key, min) < 0) {
            //     min = current.key;
            // }

            current = current.left;
        }

        return current.key;
    }

    public K lastKey() {
        // TODO: 가장 큰 key 반환. 비어 있으면 NoSuchElementException
        if(isEmpty()) throw new NoSuchElementException();

        Node<K, V> current = root;
        // K max = current.key;

        while(current.right != null) {
            // if(compare(current.key, max) > 0) {
            //     max = current.key;
            // }

            current = current.right;
        }

        return current.key;
    }

    public int size() {
        // TODO: 저장된 entry 개수 반환
        return size;
    }

    public boolean isEmpty() {
        // TODO: 비어 있으면 true 반환
        return size == 0;
    }

    // 실제로 root, parent.left, parent.right를 바꾼다.
    private void removeNode(Node<K, V> parent, Node<K, V> current) {

        if(current.left == null && current.right == null) {
            // 1. 자식 없음
            replaceChild(parent, current, null);
            return;

            // if(parent.left == current) {
            //     parent.left = null;
            // } else if(parent.right == current) {
            //     parent.right = null;
            // }
        } else if(current.left == null) {
            // 2. 오른쪽 자식만 있음
            replaceChild(parent, current, current.right);
            return;
        } else if(current.right == null) {
            // 3. 왼쪽 자식만 있음
            replaceChild(parent, current, current.left);
            return;
        }

        // 4. 자식 2개
        Node<K, V> successorParent = current;
        Node<K, V> successor = current.right; // 삭제한 node의 오른쪽 서브 트리를 탐색
        // K min = successor.key; // ❗successor를 찾는 방식, 계속 왼쪽으로 내려가면 됩니다. min을 따로 비교할 필요 X

        while(successor.left != null) {
            // if(compare(successor.key, min) < 0) { // node.key - min < 0
            //     min = successor.key;
            // }

            successorParent = successor;
            successor = successor.left;
        }

        // 삭제할 node의 key/value를 변경
        // put(successor.key, successor.value); // ❗pub(key, value)는 삭제 로직에 쓰면 안 됩니다. while(successor != null) 루프가 끝난 뒤라 successor은 null
        current.key = successor.key;
        current.value = successor.value;

        // 부모 node에 successor를 연결
        // if(parent.left == current) {
        //     parent.left = findNode(min); // ❗ 자식 2개 삭제 처리로는 부족.
        // } else if(parent.right == current) {
        //     parent.right = findNode(min);
        // }
        if(successorParent.left == successor) {
            successorParent.left = successor.right;
        } else {
            successorParent.right = successor.right;
        }
    }

    private void replaceChild(Node<K, V> parent, Node<K, V> current, Node<K, V> replacement) {
        if(parent == null) {
            root = replacement;
        } else if(parent.left == current) {
            parent.left = replacement;
        } else {
            parent.right = replacement;
        }
    }

    private Node<K, V> findNode(K key) {
        Node<K, V> current = root;

        while(current != null) {
            int cmp = compare(key, current.key);

            if(cmp == 0) {
                return current;
            }

            current = cmp < 0 ? current.left : current.right;
        }

        return null;
    }

    private int compare(K a, K b) {
        // TODO: comparator로 key 비교
        return comparator.compare(a, b);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
