package arraylist;

import linkedList.SimpleList;
import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<V> implements SimpleList<V>,Iterable {
    private Object[] array = new Object[]{};

    @Override
    public boolean add(V value) {
        array = Arrays.copyOf(array,array.length+1);
        array[array.length-1] = value;
        return true;
    }

    @Override
    public Object get(int index) {
        if(index>=0 && index<=array.length){
            return array[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean delete(int index) {
        if(index>=0 && index<=array.length){
            int newIndex = 0;
            Object[] newArray = new Object[array.length-1];
            for(int x =0;x<array.length;x++){
                if(x!=index){
                    newArray[newIndex] = array[x];
                    newIndex++;
                }
            }
            array = newArray;
            return true;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int getSize() {
        return array.length;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<V>() {
            int cursor = 0;
            @Override
            public boolean hasNext() {
                if(cursor < array.length && cursor >= 0){
                    return true;
                }
                return false;
            }

            @Override
            public V next() {
                V obj =(V) array[cursor];
                if(hasNext()){
                    cursor++;
                }
                return obj;
            }
        };
    }
}
