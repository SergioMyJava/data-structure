package LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class SimpleLinkedList<V> implements SimpleList<V> {
    int size = 0;
    Node first = null;
    Node last = null;

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
        try {
            Node target = first;
            if (index == 1) {
                return (V) target.getValue();
            }
            if (index > 1 && index <= size) {
                for (int i = 1; i <= index - 1; i++) {
                    target = target.getBehind();
                }
                return (V) target.getValue();
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return (V) new IndexOutOfBoundsException();
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
            int current = 0;
            Node node = first;
            int next = 0;

            @Override
            public boolean hasNext() {
                while (current != size) {
                    current++;
                    return true;
                }
                return false;
            }

            @Override
            public V next() {
                if (next == 0) {
                    next++;
                    return (V) node.getValue();
                }
                else if(node != null) {
                    node = node.getBehind();
                    next++;
                    return (V) node.getValue();
                }
                return null;
            }

            @Override
            public void forEachRemaining(Consumer action) {

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
