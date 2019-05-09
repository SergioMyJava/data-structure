package stack;

public interface SimpleStack<V> {
    boolean put(V value);
    V pop();
    V peek();
}
