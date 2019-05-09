package simplelist;

public interface SimpleList<V> extends Iterable<V> {
    boolean add(V value);
    Object get(int index);
    boolean delete(int index);
    int size();
}
