package stack.SimpleStackLinked;

import stack.simplestack.SimpleStack;

import java.util.EmptyStackException;
import java.util.Iterator;

public class SimpleStackLinked<V> implements SimpleStack<V>, Iterable<V> {
    Node lastNode = null;
    int size = 0;

    @Override
    public boolean put(V value) {
        Node newNode = new Node(value);
        newNode.setAhead(lastNode);
        lastNode = newNode;
        return true;
    }

    @Override
    public V pop() throws EmptyStackException {
        if (lastNode.ahead != null) {
            Node returnNode = lastNode;
            Node newLastNode = lastNode.ahead;
            lastNode = newLastNode;
            return (V) returnNode.getValue();
        }
        throw new EmptyStackException();
    }

    @Override
    public V peek() {
        if (lastNode.ahead != null) {
            return (V) lastNode.getValue();
        }
        throw new EmptyStackException();
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            Node cursor = lastNode;

            @Override
            public boolean hasNext() {
                if (lastNode.getAheadNode() != null) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public V next() {
                if (hasNext()) {
                    V value = (V) cursor.getValue();
                    cursor = cursor.getAheadNode();
                    return value;
                }
                return null;
            }
        };
    }

    private class Node<V> {
        Node ahead;
        V value;

        Node(V newValue) {
            this.value = newValue;
        }

        private Node getAheadNode() {
            return ahead;
        }

        private void setAhead(Node ahead) {
            this.ahead = ahead;
        }

        private V getValue() {
            return value;
        }
    }
}
