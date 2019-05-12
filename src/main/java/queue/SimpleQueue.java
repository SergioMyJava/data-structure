package queue;

public interface SimpleQueue<V> extends Iterable<V>{
    boolean add(V object);
    V peek();
    V poll();
    int size();
}
