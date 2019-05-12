package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLinkedQuequeTest {
    SimpleQueue<Integer> exp = new SimpleLinkedQueque<>();

    @BeforeEach
    void add() {
        exp.add(1);
        exp.add(2);
        exp.add(3);
        exp.add(4);
        exp.add(5);
        exp.add(6);
    }

    @Test
    @DisplayName("Must return first value, without delete")
    void peek() {
        assertEquals(1,exp.peek());
        assertEquals(6,exp.size());
        assertEquals(1,exp.peek());
        assertEquals(6,exp.size());
        assertEquals(1,exp.peek());
        assertEquals(6,exp.size());

    }

    @Test
    @DisplayName("Must return value, with delete")
    void poll() {
        assertEquals(1,exp.poll());
        assertEquals(5,exp.size());
        assertEquals(2,exp.poll());
        assertEquals(4,exp.size());
        assertEquals(3,exp.poll());
        assertEquals(3,exp.size());
        assertEquals(4,exp.poll());
        assertEquals(2,exp.size());
        assertEquals(5,exp.poll());
        assertEquals(1,exp.size());
        assertEquals(6,exp.poll());
        assertEquals(0,exp.size());
    }
}