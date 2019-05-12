package queue;

import java.util.Iterator;

public class SimpleLinkedQueque<V> implements SimpleQueue<V>, Iterable<V> {
    private int size = 0;
    private Node firstNode = null;
    private Node lastNode = null;

    @Override
    public boolean add(V object) {
        if (firstNode == null) {
            Node newNode = new Node(object);
            firstNode = newNode;
            lastNode = newNode;
            size++;
            return true;
        } else {
            Node newNode = new Node(object);
            lastNode.setBehind(newNode);
            lastNode = newNode;
            size++;
            return true;
        }
    }

    @Override
    public V peek() {
        if (firstNode != null) {
            return firstNode.getValue();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public V poll() {
        if (firstNode != null) {
            if (firstNode.getBehind() == null) {
                V value = firstNode.getValue();
                firstNode = null;
                lastNode = null;
                size--;
                return value;
            } else {
                V value = firstNode.getValue();
                Node newFirstNode = firstNode.getBehind();
                firstNode = newFirstNode;
                size--;
                return value;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            Node cursor = firstNode;

            @Override
            public boolean hasNext() {
                if (cursor != null) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public V next() {
                if (hasNext()) {
                    V value = cursor.getValue();
                    Node newNode = cursor.getBehind();
                    cursor = newNode;
                    return value;
                }
                throw new IndexOutOfBoundsException();
            }
        };
    }

    private class Node {
        private V value;
        private Node behind;

        Node(V value) {
            this.value = value;
        }

        private V getValue() {
            return value;
        }

        private void setBehind(Node node) {
            this.behind = node;
        }

        private Node getBehind() {
            return behind;
        }

    }
}
