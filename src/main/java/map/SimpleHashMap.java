package map;

import java.util.*;

public class SimpleHashMap<K, V> implements SimpleMap<K, V> {
    private Node<K, V>[] table;
    static int DEFAULT_CAPACITY = 16;
    private int size;
    private int thresHold;

    SimpleHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        thresHold = (int) (table.length * 0.75d);
    }

    @Override
    public V get(K key) {
        int index = (key.hashCode() & 0x7fffffff) % table.length;
        if (table[index] != null) {
            if (table[index].getNext() == null) {
                return table[index].getValue();
            } else {
                Node<K, V> nodeFromBacket = table[index];
                while (nodeFromBacket != null) {
                    if (key.equals(nodeFromBacket.getKey())) {
                        return nodeFromBacket.getValue();
                    } else {
                        nodeFromBacket = nodeFromBacket.getNext();
                    }
                }
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean put(K key, V value) {
        if (size + 1 >= thresHold) {
            doubleUp();
        }
        if (key == null) {
            throw new NullPointerException();
        }
        int hash = key.hashCode() & 0x7fffffff;
        Node<K, V> newNode = new Node(key, value, hash, null);
        int index = hash % table.length;
        if (table[index] == null) {
            table[index] = newNode;
            size++;
        } else {
            Node<K, V> nodeInTheBacket = table[index];
            K keyFromBacket = nodeInTheBacket.getKey();
            while (nodeInTheBacket != null) {
                if (keyFromBacket == key || keyFromBacket.equals(key)) {
                    nodeInTheBacket.setValue(value);
                    return true;
                }
                if (nodeInTheBacket.getNext() == null) {
                    nodeInTheBacket.setNext(newNode);
                    size++;
                    return true;
                } else {
                    nodeInTheBacket = nodeInTheBacket.getNext();
                }
            }
        }
        return false;
    }

    private void doubleUp() {
        Node<K, V>[] oldTab = table;
        thresHold *= 2;
        table = new Node[thresHold];
        for (int i = 0; i < oldTab.length; i++) {
            if (oldTab[i] != null) {
                Node<K, V> fromOldBacket = oldTab[i];
                while (fromOldBacket != null) {
                    int newIndex = fromOldBacket.getHashKey() % table.length;
                    table[newIndex] = fromOldBacket;
                    fromOldBacket = fromOldBacket.getNext();

                }
            }
        }
    }

    @Override
    public boolean remove(K key) {
        int index = (key.hashCode() & 0x7fffffff) % table.length;
        if (table[index].getNext() == null) {
            table[index] = null;
            size--;
            return true;
        } else {
            Node<K, V> nodeFromBacket = table[index];
            Node<K, V> previousNod = null;
            while (nodeFromBacket != null) {
                if (key.equals(nodeFromBacket.getKey())) {
                    if (previousNod == null) {
                        table[index] = nodeFromBacket.getNext();
                        size--;
                        return true;
                    }
                    previousNod.setNext(nodeFromBacket.getNext());
                    size--;
                    return true;
                } else {
                    previousNod = nodeFromBacket;
                    nodeFromBacket = nodeFromBacket.getNext();
                }
            }
        }
        return false;
    }

    @Override
    public List<K> keys() {
        List<K> keys = new ArrayList<>(size);
        for (int i = 0; i < table.length; i++) {
            Node nodeFromBacket = table[i];
            while (nodeFromBacket != null) {
                Node<K, V> first = nodeFromBacket;
                nodeFromBacket = nodeFromBacket.getNext();
                keys.add(first.getKey());
            }
        }
        return keys;
    }

    @Override
    public List<V> values() {
        List<V> value = new ArrayList<>(size);
        for (int i = 0; i < table.length; i++) {
            Node nodeFromBacket = table[i];
            while (nodeFromBacket != null) {
                Node<K, V> first = nodeFromBacket;
                nodeFromBacket = nodeFromBacket.getNext();
                value.add(first.getValue());
            }
        }
        return value;
    }

    @Override
    public boolean ontainsKey(K key) {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

//    @Override
//    public Iterator<V> iterator() {
//        return new Iterator<V>() {
//            int arrayCursor = 0;
//            int valueCounter;
//            Node<K, V> cursor = null;
//
//            @Override
//            public boolean hasNext() {
//                if(valueCounter == size){
//                    return false;
//                }
//                if (cursor != null || cursor.getNext() != null ) {
//                    return true;
//                }
//                if (cursor == null) {
//                    arrayCursor++;
//                }
//                return false;
//            }
//
//            @Override
//            public V next() {
//                if (hasNext()) {
//                    if(cursor.getNext() != null){
//                        Node<K,V> previousCursor = cursor;
//                        cursor = previousCursor.getNext();
//                        valueCounter++;
//                        return previousCursor.getValue();
//                    }
//                    if(cursor != null){
//
//                    }
//                    cursor = table[arrayCursor];
//
//                return cursor.getValue();
//                }
//                return null;
//            }
//        };
//    }

    static class Node<K, V> {
        int hashKey;
        Node next;
        V value;
        K key;

        Node(K key, V value, int hashKey, Node next) {
            this.hashKey = hashKey;
            this.next = next;
            this.value = value;
            this.key = key;
        }

        private int getHashKey() {
            return hashKey;
        }

        private void setValue(V value) {
            this.value = value;
        }

        private Node<K, V> getNext() {
            return next;
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
