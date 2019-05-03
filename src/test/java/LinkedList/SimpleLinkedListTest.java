package LinkedList;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleLinkedListTest<V> {

    private SimpleList exp = new SimpleLinkedList();

    @Test
    @DisplayName("Must return true")
    public void add() {
        assertTrue(exp.add(12));
        assertTrue(exp.add(1));
        assertTrue(exp.add(2));
        assertTrue(exp.add(129));
        assertTrue(exp.add(987768764));
        assertTrue(exp.add(-5));
        assertTrue(exp.add(0));
    }

    @Test
    @DisplayName("Must return value by key")
    public <V> void get() {
        assertEquals(1,exp.get(2));
//        assertEquals(987768764,exp.get(5));
//        assertEquals(-5,exp.get(6));
//        assertEquals(1,exp.get(12));
    }

//    @Test
//    @DisplayName("")
//    public void delete() {
//        assertTrue(exp.delete(5));
//        assertTrue(exp.delete(2));
//        assertTrue(exp.delete(3));
//    }
}
