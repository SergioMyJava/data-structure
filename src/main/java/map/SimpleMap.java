package map;

public interface SimpleMap<K,V> extends Iterable<V> {
    V get (K key );
    boolean put(K key,V value);
    boolean remove(K key );
    K keys();
    V values();
    boolean ontainsKey(K key );
    int getSize();
}
