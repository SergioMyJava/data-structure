package linkedlist;

import simplelist.SimpleList;

import java.util.Iterator;

public class SimpleLinkedList<V> implements SimpleList<V>, Iterable<V> {
    int size = 0;
    Node<V> first = null;
    Node<V> last = null;

    public int size(){
        return size;
    }

    @Override
    public boolean add(V value) {
        if (size == 0) {
            first = new Node(first, last, value);
            last = first;
            size++;
            return true;
        }
        if (size > 0) {
            Node newNode = new Node(last, null, value);
            last.setBehind(newNode);
            last = newNode;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public V get(int index) {
        Node<V> target = first;

        if (index == 0) {
            return target.getValue();
        }
        if(index == size-1){
            return last.getValue();
        }
        if (index > 0 && index < size) {
            for (int i = 0; i < index; i++) {
                target = target.getBehind();
            }
            return target.getValue();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean delete(int index) {
            Node target = first;
            if(index == 0){
                Node node = first.getBehind();
                node.setAhead(null);
                first = node;
                size--;
                return true;
            }
            if (index == size-1) {
                Node node = last.getAhead();
                node.setBehind(null);
                last = node;
                size--;
                return true;
            }
            if (index > 0 && index < size) {
                for (int i = 0; i < index; i++) {
                    target = target.getBehind();
                }
                Node node = target.getAhead();
                node.setBehind(target.getBehind());
                node = target.getBehind();
                node.setAhead(target.getAhead());
                size--;
                return true;
            }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            Node<V> cursor = first;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public V next() {
                V value = cursor.getValue();
                if (hasNext()) {
                    cursor = cursor.getBehind();
                }
                return value;
            }
        };
    }

    private class Node<V> {
        V value;
        Node ahead;
        Node behind;

        Node(Node ahead, Node behind, V value) {
            this.ahead = ahead;
            this.behind = behind;
            this.value = value;
        }

        private void setBehind(Node newNode) {
            this.behind = newNode;
        }

        private void setAhead(Node newNode) {
            this.ahead = newNode;
        }

        private Node getAhead() {
            return ahead;
        }

        private Node getBehind() {
            return behind;
        }

        private V getValue() {
            return value;
        }
    }
}
