package map;

import java.util.Comparator;
import java.util.List;

public class SimpleSortedMap<K extends Comparable, V> implements SimpleMap<K, V> {
    Node<K, V> root = null;
    Comparator<? extends K> comparator;
    int size;

    SimpleSortedMap() {
    }

    SimpleSortedMap(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        if (root == null) {
            root = new Node(value, key, null, null);
            size++;
            return true;
        }
        Node<K, V> nodeCursor = root;
        K keyCursor = root.getKey();

        if (keyCursor.compareTo(key) > 0) {
            Node<K, V> left = nodeCursor.getLeft();
            if (left == null) {
                nodeCursor.setLeft(new Node(value, key, null, null));
                size++;
                return true;
            } else {
                nodeCursor = nodeCursor.getLeft();
                put(key, value);
            }
        }

        if (keyCursor.compareTo(key) == 0) {
            nodeCursor.setValue(value);
            return true;
        }

        if (keyCursor.compareTo(key) < 0) {
            Node<K, V> right = nodeCursor.getRight();
            if (right == null) {
                nodeCursor.setRight(new Node(value, key, null, null));
                size++;
            } else {
                nodeCursor = nodeCursor.getRight();
                put(key, value);
            }
        }
        return false;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public List keys() {
        return null;
    }

    @Override
    public List values() {
        return null;
    }

    @Override
    public boolean ontainsKey(K key) {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    private class KeyComparator implements Comparator<K> {
        @Override
        public int compare(K o1, K o2) {
            return o1.compareTo(o2);
        }
    }

    private class Node<K, V> {
        V value;
        K key;
        Node<K, V> left;
        Node<K, V> right;

        Node(V value, K key, Node left, Node right) {
            this.value = value;
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        public Node<K, V> getLeft() {
            return left;
        }

        public Node<K, V> getRight() {
            return right;
        }

        private void setValue(V value) {
            this.value = value;
        }

        private void setLeft(Node left) {
            this.left = left;
        }

        private void setRight(Node right) {
            this.right = right;
        }

    }
}
