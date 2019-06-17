package map;

import java.util.*;

public class SimpleTreeMap<K extends Comparable, V> implements SimpleMap<K, V>, Iterable {
    List listValue;
    List listKey;
    Node<K, V> root = null;
    int size;

    @Override
    public V get(K key) {
        if (root == null) {
            throw new NullPointerException();
        }
        return getByTheKey(key, root);
    }

    private V getByTheKey(K key, Node<K, V> nodeCursor) {
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
        K cursorKey = cursorNode.getKey();
        Node<K, V> parent = null;

        if (root == null) {
            throw new NullPointerException();
        }

        if (key.compareTo(cursorKey) < 0) {                                             // 1-ый случай когда искомая
            parent = cursorNode;
            removeByTheKey(key, cursorNode.getLeft());                                 //нода лежит слева
        }

        if (key.compareTo(key) > 0) {                                                   // 2-ой случай когда искомая
            parent = cursorNode;                                                        // нода лежит справа
            removeByTheKey(key, cursorNode.getRight());
        }

        if (cursorKey.compareTo(key) == 0) {                                            // 3 случай когда нашли ноду
            if (cursorNode.getLeft() == null && cursorNode.getRight() == null) {        //3.1 случай когда у удаляемого
                if (parent.getRight() == cursorNode) {                                  // элемента левая и правая нода
                    parent.setRight(null);                                              // нул
                    size--;
                    return true;
                }
                if (parent.getLeft() == cursorNode) {
                    parent.setLeft(null);
                    size--;
                    return true;
                }
            }

            if ( cursorNode.getLeft() != null || cursorNode.getRight() == null){        //3.2 случай когда у удаляемого
                if (parent.getRight() == cursorNode) {                                  //3.2.1элемента левая нода не нул
                    parent.setRight(cursorNode.getLeft());                              //а правая нода нул
                    size--;
                    return true;
                }
                if (parent.getLeft() == cursorNode) {
                    parent.setLeft(cursorNode.getLeft());
                    size--;
                    return true;
                }
            }

            if ( cursorNode.getLeft() == null || cursorNode.getRight() != null){        //3.2.2случай когда у удаляемого
                if (parent.getRight() == cursorNode) {                                  //элемента левая нода нул а
                    parent.setRight(cursorNode.getRight());                             //правая нода нет
                    size--;
                    return true;
                }
                if (parent.getLeft() == cursorNode) {
                    parent.setLeft(cursorNode.getRight());
                    size--;
                    return true;
                }
            }

            if (cursorNode.getLeft() != null || cursorNode.getRight() != null){         //3.2.3 когда оба листа не нул
                if (parent.getRight() == cursorNode) {                   //тогда берем и подставляем левый лист или узел
                    parent.setRight(cursorNode.getLeft());
                    size--;
                    return true;
                }
                if (parent.getLeft() == cursorNode) {
                    parent.setLeft(cursorNode.getLeft());
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<K> keys() {
        listKey = new LinkedList();
        return getAllKeys(root);
    }

    public List getAllKeys(Node node) {
        if (node != null) {
            listKey.add(node.getKey());
            getAllKeys(node.getLeft());
            getAllKeys(node.getRight());
        }
        return listKey;
    }

    @Override
    public List values() {
        listValue = new LinkedList();
        return getAllValues(root);
    }

    private List getAllValues(Node node) {
        if (node != null) {
            listValue.add(node.getValue());
            getAllValues(node.getLeft());
            getAllValues(node.getRight());
        }
        return listValue;
    }

    @Override
    public boolean ontainsKey(K key) {
        Iterator test = this.iterator();
        while (test.hasNext() == true) {
            Node<K, V> node = (Node<K, V>) test.next();
            if (node.getKey() == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new IteratorForTreeMap(root);
    }

    public static class Node<K, V> {
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

        public String toString() {
            return "Key = " + key + " Value = " + value;
        }
    }

    public class IteratorForTreeMap<K, V> implements Iterator {
        SimpleTreeMap.Node<K, V> root;
        Stack<SimpleTreeMap.Node> stack;
        boolean firstPass = true;

        IteratorForTreeMap(SimpleTreeMap.Node<K, V> root) {
            stack = new Stack<>();
            this.root = root;
        }

        @Override
        public boolean hasNext() {
            if (stack.isEmpty() && firstPass == true) {
                getAllNodes(root);
                firstPass = false;
            }
            return (!stack.isEmpty());
        }

        @Override
        public Object next() {
            if (!stack.isEmpty()) {
                return stack.pop();
            }

            return null;
        }

        private void getAllNodes(SimpleTreeMap.Node<K, V> node) {
            if (node != null) {
                stack.add(node);
                getAllNodes(node.getLeft());
                getAllNodes(node.getRight());
            }
        }
    }
}
