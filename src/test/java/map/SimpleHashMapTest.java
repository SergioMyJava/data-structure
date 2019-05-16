package map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {

    SimpleMap<String, String> exp = new SimpleHashMap();
    List keyTest = new ArrayList();
    List valueTest = new ArrayList();
    @BeforeEach
    void put() {
        exp.put("Л.Н. Толстой","Детство");
        exp.put("Л.И. Ленин","Мир");
        exp.put("А.Н. Чехов","По Сибири");
        exp.put("Гоголь","Мертвые души");
        exp.put("Пушкин","Онегин");
        exp.put("Лермонтов","Бородино");
        keyTest.add("Л.И. Ленин");
        keyTest.add("Лермонтов");
        keyTest.add("Гоголь");
        keyTest.add("А.Н. Чехов");
        keyTest.add("Пушкин");
        keyTest.add("Л.Н. Толстой");
        valueTest.add("Мир");
        valueTest.add("Бородино");
        valueTest.add("Мертвые души");
        valueTest.add("По Сибири");
        valueTest.add("Онегин");
        valueTest.add("Детство");

    }

    @Test
    void getSize() {
    assertEquals(6,exp.getSize());
    }

    @Test
    void get() {
        assertEquals("Онегин",exp.get("Пушкин"));
        assertEquals("Мир",exp.get("Л.И. Ленин"));
        assertEquals("Бородино",exp.get("Лермонтов"));
        assertEquals("Детство",exp.get("Л.Н. Толстой"));
        assertEquals("Онегин",exp.get("Пушкин"));
    }

    @Test
    void remove() {
        assertEquals(true,exp.remove("Пушкин"));
        assertEquals(5,exp.getSize());
        assertEquals(true,exp.remove("Л.И. Ленин"));
        assertEquals(4,exp.getSize());
        assertEquals(true,exp.remove("Л.Н. Толстой"));
        assertEquals(3,exp.getSize());
        assertEquals(true,exp.remove("Лермонтов"));
        assertEquals(2,exp.getSize());
    }

    @Test
    void keys() {
        assertEquals(true,keyTest.equals(exp.keys()));
    }

    @Test
    void values() {
        assertEquals(true,valueTest.equals(exp.values()));
    }

    @Test
    void ontainsKey() {
        assertEquals(true,exp.ontainsKey("Л.И. Ленин"));
        assertEquals(true,exp.ontainsKey("Гоголь"));
        assertEquals(true,exp.ontainsKey("Л.Н. Толстой"));
        assertEquals(true,exp.remove("Л.Н. Толстой"));
        assertEquals(false,exp.ontainsKey("Л.Н. Толстой"));
        assertEquals(true,exp.remove("Гоголь"));
        assertEquals(false,exp.ontainsKey("Гоголь"));

    }

}