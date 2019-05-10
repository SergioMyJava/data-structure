package stack;

public interface SimpleStack<V> extends Iterable<V>{
    boolean put(V value);
    V pop();
    V peek();
}
