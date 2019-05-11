package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayStackTest {
    SimpleStack<Integer> exp= new SimpleArrayStack();

    @BeforeEach
    void put() {
        exp.put(0);
        exp.put(1);
        exp.put(2);
        exp.put(3);
        exp.put(4);
        exp.put(5);
        exp.put(6);
        exp.put(7);
        exp.put(8);
        exp.put(9);
    }

    @Test
    @DisplayName("Should pop numbers in right order to prove that it's a stack")
    void pop() {
        assertEquals(10,exp.getSize());
        assertEquals(9,exp.pop());
        assertEquals(9,exp.getSize());
        assertEquals(8,exp.pop());
        assertEquals(8,exp.getSize());
        assertEquals(7,exp.pop());
        assertEquals(7,exp.getSize());
        assertEquals(6,exp.pop());
        assertEquals(6,exp.getSize());
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