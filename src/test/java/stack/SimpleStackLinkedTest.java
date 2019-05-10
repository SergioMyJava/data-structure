package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleStackLinkedTest {
    SimpleStack<Integer> exp = new SimpleStackLinked<>();

    @BeforeEach
    void put() {
        assertTrue(exp.put(1));
        assertTrue(exp.put(2));
        assertTrue(exp.put(3));
        assertTrue(exp.put(4));
        assertTrue(exp.put(5));
        assertTrue(exp.put(6));
    }

    @Test
    void pop() {
        assertEquals(6,exp.pop());
        assertEquals(5,exp.pop());
        assertEquals(4,exp.pop());
        assertEquals(3,exp.pop());
        assertEquals(2,exp.pop());
        assertEquals(1,exp.pop());
    }

    @Test
    void peek() {
        assertEquals(6,exp.peek());
        assertEquals(6,exp.peek());
        assertEquals(6,exp.peek());
        assertEquals(6,exp.peek());
    }
}