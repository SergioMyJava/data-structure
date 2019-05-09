package arraylist;

import simplelist.SimpleList;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<V> implements SimpleList<V>,Iterable<V> {
    private V[] array = null;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    @Override
    public boolean add(V value) {
        if(array == null){
            array =(V[]) new Object[DEFAULT_CAPACITY];
        }
        if(array.length > size){
            array[size] = value;
            size++;
        }
        else {
            V [] oldArray = array;
            V [] newArray = Arrays.copyOf(oldArray,array.length*2);
            array = newArray;
            add(value);
        }
        return true;
    }

    @Override
    public V get(int index) {
        if (index >= 0 && index <= array.length) {
            return array[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean delete(int index) {
        if (index >= 0 && index <= size) {
            for (int x = index; x < size; x++) {
                if((x+1)!= size)
                array[x] = array[x+1];
            }
            size--;
            return true;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (cursor < size && cursor >= 0) {
                    return true;
                }
                return false;
            }

            @Override
            public V next() {
                V obj = array[cursor];
                if (hasNext()) {
                    cursor++;
                }
                return obj;
            }
        };
    }
}
