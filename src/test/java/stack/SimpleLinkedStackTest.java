package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLinkedStackTest {
    SimpleStack<Integer> exp = new SimpleLinkedStack<>();

    @BeforeEach
    void put() {
        exp.put(1);
        exp.put(2);
        exp.put(3);
        exp.put(4);
        exp.put(5);
        exp.put(6);
    }

    @Test
    @DisplayName("Should pop numbers in right order to prove that it's a stack")
    void pop() {
        assertEquals(6,exp.getSize());
        assertEquals(6,exp.pop());
        assertEquals(5,exp.getSize());
        assertEquals(5,exp.pop());
        assertEquals(4,exp.getSize());
        assertEquals(4,exp.pop());
        assertEquals(3,exp.getSize());
        assertEquals(3,exp.pop());
        assertEquals(2,exp.getSize());
        assertEquals(2,exp.pop());
        assertEquals(1,exp.getSize());
        assertEquals(1,exp.pop());
        assertEquals(0,exp.getSize());
    }

    @Test
    @DisplayName("Should get an item with the peek method but keep it in the stack")
    void peek() {
        assertEquals(6,exp.getSize());
        assertEquals(6,exp.peek());
        assertEquals(6,exp.getSize());
        assertEquals(6,exp.peek());
        assertEquals(6,exp.getSize());
        assertEquals(6,exp.peek());
        assertEquals(6,exp.getSize());
        assertEquals(6,exp.peek());
    }
}