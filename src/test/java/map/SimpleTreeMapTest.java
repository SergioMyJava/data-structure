package map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTreeMapTest {

    SimpleMap<Integer, String> exp = new SimpleTreeMap<>();
    List <Integer> keysList = new LinkedList<Integer>();
    List <String> valuesList = new LinkedList<String>();

    @BeforeEach
    void put() {
        exp.put(1,"one");
        exp.put(2,"two");
        exp.put(3,"three");
        exp.put(4,"for");
        keysList.add(1);
        keysList.add(2);
        keysList.add(3);
        keysList.add(4);
        valuesList.add("one");
        valuesList.add("two");
        valuesList.add("three");
        valuesList.add("for");
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
        assertEquals(true,exp.remove(3));
        assertEquals(3,exp.getSize());
        assertEquals(true,exp.remove(4));
        assertEquals(2,exp.getSize());
    }

    @Test
    void keys() {
        assertEquals(true,keysList.equals(exp.keys()));
    }

    @Test
    void values() {
        assertEquals(true,valuesList.equals(exp.values()));
    }

    @Test
    void ontainsKey() {
        assertEquals(true,exp.ontainsKey(1));
        assertEquals(true,exp.ontainsKey(2));
        assertEquals(true,exp.ontainsKey(3));
        assertEquals(true,exp.ontainsKey(4));
        assertEquals(false,exp.ontainsKey(5));
        assertEquals(false,exp.ontainsKey(6));
    }

}