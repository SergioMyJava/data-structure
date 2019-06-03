package map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleTreeMap<K extends Comparable, V> implements SimpleMap<K, V>, Iterable {
    List<Node> list;
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

    public V getByTheKey(K key, Node<K, V> nodeCursor) {
        Node<K, V> newCursor = nodeCursor;
        K keyCursor = newCursor.getKey();

        if (keyCursor.compareTo(key) == 0)
            return newCursor.getValue();


        else {
            if (keyCursor.compareTo(key) > 0) {
                Node<K, V> newNodeCursor = newCursor.getLeft();
                return getByTheKey(key, newNodeCursor);
            }

            if (keyCursor.compareTo(key) < 0) {
                Node<K, V> newNodeCursor = newCursor.getRight();
                return getByTheKey(key, newNodeCursor);
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
        return removeByTheKey(key, root);
    }

    private boolean removeByTheKey(K key, Node<K, V> cursorNode) {
        if (root == null) {
            throw new NullPointerException();
        }
        K cursorKey = cursorNode.getKey();
        if (cursorKey.compareTo(key) == 0) {
            if (cursorNode.getRight() == null && cursorNode.getLeft() == null) {

            }
            return true;
        }
        return false;
    }

    @Override
    public List keys() {
        listKey = new LinkedList();
        return getAllKeys(root);
    }

    public List getAllKeys(Node node) {
        if (node != null) {
            listKey.add((K) node.getKey());
            getAllKeys(node.getLeft());
            getAllKeys(node.getRight());
        }
    return  listKey;
    }


    @Override
    public List values() {
        listValue = new LinkedList();
        return getAllValues(root);
    }

    private List getAllValues(Node node){
        if (node != null) {
            listValue.add((K) node.getValue());
            getAllValues(node.getLeft());
            getAllValues(node.getRight());
        }
        return  listValue;
    }

    @Override
    public boolean ontainsKey(K key) {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node<K,V> cursor = root;
            @Override
            public boolean hasNext() {
                if(cursor != null){
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                if(hasNext()){
                    //сдесь я должен что то сделать с курсосром не пойму что
                    if(cursor.getLeft() != null ){
                        cursor = cursor.getLeft();
                        return next();
                    }
                    if(cursor.getLeft() != null){
                        cursor = cursor.getLeft();
                        return next();
                    }
                }
                return null;
            }
        };
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
