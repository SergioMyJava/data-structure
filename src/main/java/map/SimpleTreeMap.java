package map;

import java.util.Comparator;
import java.util.List;

public class SimpleTreeMap<K extends Comparable, V> implements SimpleMap<K, V> {
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
        Node<K,V> newCursor = nodeCursor;
        K keyCursor = newCursor.getKey();
//        while (keyCursor != key){
//            int cmd = keyCursor.compareTo(key);
//            if(cmd > 0)
//                getByTheKey(key,newCursor.getLeft()) ;
//
//            if(cmd < 0)
//                getByTheKey(key,newCursor.getRight());
//
//            else
//                return newCursor.getValue();
//
//        }
        Node<K, V> cursorNode = nodeCursor;
        if (keyCursor.compareTo(key) == 0) {
            return cursorNode.getValue();                       // при наступлении этого событи он прыгает
        }

        if (keyCursor.compareTo(key) > 0) {
            Node<K, V> newNodeCursor = cursorNode.getLeft();
            getByTheKey(key, newNodeCursor);                    //суда
        }

        if (keyCursor.compareTo(key) < 0) {
            Node<K, V> newNodeCursor = cursorNode.getRight();
            getByTheKey(key, newNodeCursor);
        }
        return null;                                            //потом суда, почему мне вообще не ясно
    }
    
    private static Integer count = 0;

    public static void main(String[] args) {

        System.out.println(smartMethod(count));
        count = 0;
        System.out.println(dumbMethod(count));
        System.out.println("И таки как, есть разница? Нужно было ретурны расставить, не?");
        
    }

    private static Integer smartMethod(Integer count) {
        if (count > 10) {
            return count;
        } else if (true) {
            return smartMethod(++count);
        }

        return null;
    }

    private static Integer dumbMethod(Integer count) {
        if (count > 10) {
            return count;
        } else if (true) {
            dumbMethod(++count);
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
        return removeByTheKey(key,root);
    }

    private boolean removeByTheKey(K key,Node<K,V> cursorNode){
        if(root == null){
            throw new NullPointerException();
        }
        K cursorKey = cursorNode.getKey();
        if(cursorKey.compareTo(key) == 0){
            if(cursorNode.getRight() == null && cursorNode.getLeft() == null){

            }
            return true;
        }
        return false;
    }

    @Override
    public List keys() {
        return null;
    }

    @Override
    public List values() {
        return null;
    }

    @Override
    public boolean ontainsKey(K key) {
        return false;
    }

    @Override
    public int getSize() {
        return size;
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
