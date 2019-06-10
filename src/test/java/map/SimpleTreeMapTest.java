package map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTreeMapTest {

    SimpleMap<Integer, String> exp = new SimpleTreeMap<>();

    @BeforeEach
    void put() {
        exp.put(1,"one");
        exp.put(2,"two");
        exp.put(3,"three");
        exp.put(4,"for");
    }

    @Test
    void get() {
        assertEquals("for",exp.get(4));
        assertEquals("three",exp.get(3));
        assertEquals("two",exp.get(2));
        assertEquals("one",exp.get(1));
    }

    @Test
    void remove() {
    }

    @Test
    void keys() {
    }

    @Test
    void values() {
    }

    @Test
    void ontainsKey() {
    }

}