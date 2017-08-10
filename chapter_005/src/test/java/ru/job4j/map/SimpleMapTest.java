package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Simple Map.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 09.08.2017
 */

public class SimpleMapTest {
    /**
     * Test add without collision.
     */
    @Test
    public void whenAddKeyAndValueToArrayAndGetValueWithoutCollision() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap();
        simpleMap.insert("asd", 123);
        Integer result = simpleMap.get("asd");
        assertThat(result, is(123));
    }

    /**
     * Test add with collision.
     */
    @Test
    public void whenAddKeyAndValueToArrayWithCollision() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap();
        simpleMap.insert("asd", 123);
        boolean result = simpleMap.insert("asd", 123);
        assertThat(result, is(false));
    }

    /**
     * Test delete exist value.
     */
    @Test
    public void whenDeleteExistValueFromArray() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap();
        simpleMap.insert("asd", 123);
        boolean result = simpleMap.delete("asd");
        assertThat(result, is(true));
    }

    /**
     * Test delete non exist value.
     */
    @Test
    public void whenDeleteNonExistValueFromArray() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap();
        simpleMap.insert("asd", 123);
        boolean result = simpleMap.delete("dsa");
        assertThat(result, is(false));
    }

    /**
     * Test Iterator.
     */
    @Test
    public void testIterationInRealCondition() {
        String result = null;
        String expected = "ASD";
        SimpleMap<Integer, String> simpleMap = new SimpleMap();
        simpleMap.insert(1, expected);
        Iterator<String> iterator = simpleMap.iterator();
        while (iterator.hasNext()) {
            result = iterator.next();
        }
        assertThat(result, is(expected));
    }
}
