package list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListTest {
    private SimpleList exp = new SimpleArrayList();

    @BeforeEach
    void add() {
        exp.add(11);
        exp.add(12);
        exp.add(13);
        exp.add(14);
        exp.add(15);
        exp.add(16);
    }

    @Test
    @DisplayName("Must return value by index")
    void get() {
        assertEquals(12,exp.get(1));
        assertEquals(11,exp.get(0));
        assertEquals(15,exp.get(4));
        assertEquals(16,exp.get(5));
    }

    @Test
    void delete() {
        assertTrue(exp.delete(5));
        assertTrue(exp.delete(4));
        assertTrue(exp.delete(0));
        assertTrue(exp.delete(1));
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