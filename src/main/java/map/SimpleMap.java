package map;

import java.util.List;

public interface SimpleMap<K,V> {
    V get (K key );
    boolean put(K key,V value);
    boolean remove(K key );
    List<K> keys();
    List<V> values();
    boolean ontainsKey(K key );
    int getSize();
}
