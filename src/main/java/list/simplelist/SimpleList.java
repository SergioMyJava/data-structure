package list.simplelist;

public interface SimpleList<V> extends Iterable<V> {
    boolean add(V value);
    V get(int index);
    boolean delete(int index);
    int size();
}
