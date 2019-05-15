package map;

public interface SimpleMap<K,V> extends Iterable<V> {
    K get (K key );
    boolean put(K key,V value);
    boolean remove(K key );
    K keys();
    V values();
    boolean ontainsKey(K key );
}
