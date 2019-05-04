package linkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class SimpleIterator<Node> implements Iterator<Node> {
    SimpleList processedList;


    public boolean hasNext() {
        return false;
    }

    public Node next() {
        return null;
    }

    public void remove() {

    }

    public void forEachRemaining(Consumer action) {

    }
}
