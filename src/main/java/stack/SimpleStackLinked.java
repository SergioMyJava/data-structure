package stack;

import java.util.EmptyStackException;
import java.util.Iterator;

public class SimpleStackLinked<V> implements SimpleStack<V>, Iterable<V> {
    private Node<V> lastNode = null;
    private int size = 0;

    public int getSize(){
        return size;
    }

    @Override
    public boolean put(V value) {
        Node<V> newNode = new Node(value);
        newNode.setAhead(lastNode);
        lastNode = newNode;
        size++;
        return true;
    }

    @Override
    public V pop() throws EmptyStackException {
        if(lastNode != null) {
            if (lastNode.ahead == null) {
                Node<V> returnNode = lastNode;
                lastNode = null;
                return returnNode.getValue();
            }
            else{
                Node<V> returnNode = lastNode;
                Node newLastNode = lastNode.ahead;
                lastNode = newLastNode;
                size--;
                return returnNode.getValue();
            }
        }
        throw new EmptyStackException();
    }

    @Override
    public V peek() {
        if(lastNode != null) {
            if (lastNode.ahead == null) {
                return lastNode.value;
            } else {
                return lastNode.getValue();
            }
        }
        throw new EmptyStackException();
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            Node cursor = lastNode;

            @Override
            public boolean hasNext() {
                if(cursor != null){
                    return true;
                }
                else {
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
