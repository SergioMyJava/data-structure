package Queue;

public interface SimpleQueue<V> extends Iterable<V>{
    boolean add(V object);
    V peek();
    V poll();
    int getSize();
}
