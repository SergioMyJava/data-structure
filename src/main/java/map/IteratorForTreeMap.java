package map;

import java.util.Iterator;
import java.util.Stack;

public class IteratorForTreeMap<K,V> implements Iterator {
    SimpleTreeMap.Node<K,V> root;
    Stack<SimpleTreeMap.Node> stack = new Stack<>();
    boolean firstPass = true;

    IteratorForTreeMap(SimpleTreeMap.Node<K,V> root){
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
        if(!stack.isEmpty()){
            return stack.pop();
        }

        return null;
    }

    private void getAllNodes(SimpleTreeMap.Node<K,V> node){
        if(node != null){
            stack.add(node);
            getAllNodes(node.getLeft());
            getAllNodes(node.getRight());
        }
    }
}
