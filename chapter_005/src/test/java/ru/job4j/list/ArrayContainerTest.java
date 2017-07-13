package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task List.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 13.07.2017
 */

public class ArrayContainerTest {
    /**
     * Test add.
     *
     * @throws Exception exception.
     */
    @Test
    public void whenAddValueInsideSizeOfArrayContainer() throws Exception {
        ArrayContainer<String> cont = new ArrayContainer();
        cont.add("1");
        cont.add("2");
        String expected = "2";
        String result = cont.get(1);
        assertThat(result, is(expected));
    }

    /**
     * Test add and increase array.
     *
     * @throws Exception exception.
     */
    @Test
    public void whenAddValueOutsizeOfArrayContainer() throws Exception {
        ArrayContainer<String> cont = new ArrayContainer<>(1);
        for (int i = 0; i < 4; i++) {
            cont.add(String.valueOf(i));
        }
        String expected = "3";
        String result = cont.get(3);
        assertThat(result, is(expected));
    }

    /**
     * Test Iterator.
     */
    @Test
    public void testIteratorInRealCondition() {
        String result = null;
        ArrayContainer<String> cont = new ArrayContainer<>();
        for (int i = 0; i < 5; i++) {
            cont.add(String.valueOf(i));
        }
        ArrayContainerIterator<String> it = new ArrayContainerIterator(cont);
        while (it.hasNext()) {
            result = it.next();
        }
        String expected = "4";
        assertThat(result, is(expected));
    }
}