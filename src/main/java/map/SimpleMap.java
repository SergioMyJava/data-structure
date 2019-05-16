package map;

import java.util.List;

public interface SimpleMap<K,V> {
    V get (K key );
    boolean put(K key,V value);
    boolean remove(K key );
    List keys();
    List values();
    boolean ontainsKey(K key );
    int getSize();
}
