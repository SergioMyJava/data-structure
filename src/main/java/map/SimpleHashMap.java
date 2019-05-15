package map;

import java.util.Iterator;
import java.util.Objects;

public class SimpleHashMap<K, V> implements SimpleMap<K, V> {
    private Node<K, V>[] table;
    static int DEFAULT_CAPACITY = 16;
    private int size;
    private double thresHold;

    SimpleHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        thresHold = table.length * 0.75d;
    }

    @Override
    public K get(K key) {
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        if (size + 1 >= thresHold) {
            thresHold *= 2;
            doubleUp();
        }
        Node<K, V> newNode = new Node(key, value, hashKey(key), null);
        int index = hashKey(key) % table.length;
        if (key == null) {
            Node cursor = table[0];
            if (cursor == null) {
                table[0] = newNode;
                size++;
                return true;
            } else {
                Node nodeFromTable = cursor;
                if (nodeFromTable.getKey().equals(key)) {
                    nodeFromTable.setValue(value);
                    return true;
                } else if (nodeFromTable.next == null) {
                    nodeFromTable.setNext(newNode);
                    size++;
                    return true;
                }
            }
        }

        
        return false;
    }

    private int hashKey(K key) {
        return key.hashCode() * 31 + 5;
    }

    private void doubleUp() {
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public K keys() {
        return null;
    }

    @Override
    public V values() {
        return null;
    }

    @Override
    public boolean ontainsKey(K key) {
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return null;
    }

    static class Node<K, V> {
        int hashKey;
        Node next;
        V value;
        K key;

        Node(K key, V value, int hashKey, Node next) {
            this.key = key;
            this.next = next;
            this.value = value;
            this.key = key;
        }

        private void setValue(V value) {
            this.value = value;
        }

        private V getValue() {
            return value;
        }

        private K getKey() {
            return key;
        }

        private void setNext(Node newNode) {
            this.next = newNode;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (getClass() == o.getClass()) {
                Node<K, V> equalNode = (Node) o;
                return (equalNode.getKey() == key && equalNode.getValue() == value);
            }
            return false;
        }
    }
}
