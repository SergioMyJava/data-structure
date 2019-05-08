package linkedlist;

public interface SimpleList<V> extends Iterable {
    boolean add(V value);
    Object get(int index);
    boolean delete(int index);
    int getSize();
}
