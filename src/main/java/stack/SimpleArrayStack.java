package stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class SimpleArrayStack<V> implements SimpleStack<V>, Iterable<V> {
    private V[] array = null;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private int lastindex;

    @Override
    public boolean put(V value) {
        if (array == null) {
            array = (V[]) new Object[DEFAULT_CAPACITY];
        }
        if(size == array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = value;
        checkCapacity();
        size++;
        return true;
    }

    private void checkCapacity() {
        if (array.length / 2 == size) {
            array = Arrays.copyOf(array, size);
        }
        if(size == array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public V pop() {
        if (size != 0) {
            int primarySize = size;
            size--;
            return array[primarySize-1];
        }
        throw new EmptyStackException();
    }

    @Override
    public V peek() {
        if (size != 0) {
            return array[size-1];
        }
        throw new EmptyStackException();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int cursorSize = size;

            @Override
            public boolean hasNext() {
                if (cursorSize != 0) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public V next() {
                if (hasNext()) {
                    int returnedCursor = cursorSize;
                    cursorSize--;
                    return array[cursorSize];
                }
                return null;
            }
        };
    }
}
