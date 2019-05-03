package LinkedList;

import java.util.Iterator;

public class SimpleLinkedList<V> implements SimpleList<V>, Iterable {
    int size = 0;
    Node<V> first = null;
    Node<V> last = null;

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

    public V get(int index) {
        Node<V> target = first;
        if (index == 1) {
            return target.getValue();
        }
        if (index > 1 && index <= size) {
            for (int i = 1; i <= index - 1; i++) {
                target = target.getBehind();
            }
            return target.getValue();
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean delete(int index) {
        try {
            Node target = first;
            if (index == size) {
                Node node = last;
                node.setAhead(null);
                size--;
                return true;
            }
            if (index > 0 && index < size) {
                for (int i = 1; i <= index - 1; i++) {
                    target = target.getBehind();
                }
                Node node = target.getAhead();
                node.setBehind(target.getBehind());// for an element that stands in front of the element being deleted,
                // change the link of the element of the element following it
                node = target.getBehind();
                node.setAhead(target.getAhead());
                size--;
                return true;
            }
        } catch (NullPointerException e) {
            System.out.println("Вы выскочили за пределы списка!");
        }
        return false;
    }

    public Iterator iterator() {
        return new Iterator() {
            Node<V> cursor = first;

            @Override
            public boolean hasNext() {
                if (cursor != null) {
                    return true;
                }
                return false;
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
