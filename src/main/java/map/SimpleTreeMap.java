package map;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleTreeMap<K extends Comparable, V> implements SimpleMap<K, V> {
    Node<K, V> root = null;
    Comparator<? extends K> comparator;
    int size;

    SimpleTreeMap() {
    }

    SimpleTreeMap(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public V get(K key) {
        if (root == null) {
            throw new NullPointerException();
        }
        return getByTheKey(key, root);
    }

    private V getByTheKey(K key, Node<K, V> nodeCursor) {
        K keyCursor = nodeCursor.getKey();
        if (keyCursor.compareTo(key) == 0) {
            V returnValue = nodeCursor.getValue();
            return returnValue;
        }
        else{

                if (keyCursor.compareTo(key) > 0) {
                    Node<K, V> newNodeCursor = nodeCursor.getLeft();
                    getByTheKey(key, newNodeCursor);
                }

                if (keyCursor.compareTo(key) < 0) {
                    Node<K, V> newNodeCursor = nodeCursor.getRight();
                    getByTheKey(key, newNodeCursor);
                }
            }
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        return addNode(key, value, root);
    }

    private boolean addNode(K key, V value, Node<K, V> nodeCursor) {
        if (root == null) {
            root = new Node(value, key, null, null);
            size++;
            return true;
        }

        K keyCursor = nodeCursor.getKey();

        if (keyCursor.compareTo(key) > 0) {
            Node<K, V> left = nodeCursor.getLeft();
            if (left == null) {
                nodeCursor.setLeft(new Node(value, key, null, null));
                size++;
                return true;
            } else {
                Node<K, V> newNodeCursor = nodeCursor.getLeft();
                addNode(key, value, newNodeCursor);
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
                Node<K, V> newNodeCursor = nodeCursor.getRight();
                addNode(key, value, newNodeCursor);
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
