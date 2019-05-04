package LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class SimpleLinkedListTest<V> {

    private SimpleList exp = new SimpleLinkedList();

    @Test
    @Before
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
    @DisplayName("Must return value by index")
    public void get() {
        assertEquals(12, exp.get(0));
        assertEquals(-5, exp.get(5));
        assertEquals(0, exp.get(6));
        assertEquals(1, exp.get(1));
    }

    @Test
    @DisplayName("Must return true")
    public void delete() {
        assertTrue(exp.delete(0));
        assertTrue(exp.delete(2));
        assertTrue(exp.delete(3));
        assertTrue(exp.delete(3));
        assertEquals(3,exp.getSize());
    }

    @Test
    @DisplayName("Must Exaption")
    public void shouldThrowException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->  exp.get(8));
        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->  exp.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->  exp.delete(8));
        Assertions.assertThrows(IndexOutOfBoundsException.class,() ->  exp.delete(-1));
    }
}
