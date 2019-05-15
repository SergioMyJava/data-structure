package map;

import java.util.Iterator;

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
    public V get(K key) {
        int index = hashKey(key) % table.length;
        if (table[index].getNext() == null) {
            return table[index].getValue();
        } else {
            Node<K, V> nodeFromBacket = table[index];
            if (nodeFromBacket != null) {
                if (key.equals(nodeFromBacket.getKey())) {
                    return nodeFromBacket.getValue();
                } else {
                    nodeFromBacket = nodeFromBacket.getNext();
                }
            }
        }
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        if (size + 1 >= thresHold) {
            thresHold *= 2;
            doubleUp();
        }
        if (key == null) {
            throw new NullPointerException();
        }
        Node<K, V> newNode = new Node(key, value, hashKey(key), null);
        int index = hashKey(key) % table.length;
        if (table[index] == null) {
            table[index] = newNode;
        }
        if (table[index] != null) {
            Node<K, V> nodeInTheBacket = table[index];
            K keyFromBacket = nodeInTheBacket.getKey();
            if (nodeInTheBacket != null) {
                if (keyFromBacket.equals(key) || keyFromBacket == key) {    //обрати внимание, я проверяю ссылка на тот-же ключ или нет это правильно менять значение в таком случае?
                    nodeInTheBacket.setValue(value);
                    return true;
                }
                if (nodeInTheBacket.equals(newNode)) {
                    return false;
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

    private int hashKey(K key) {
        return key.hashCode() * 31 + 5;
    }

    private void doubleUp() {
        Node<K, V>[] oldTab = table;

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
