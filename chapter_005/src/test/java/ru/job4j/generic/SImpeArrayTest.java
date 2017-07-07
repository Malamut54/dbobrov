package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Chapter Generic.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 06.07.2017
 */

public class SImpeArrayTest {
    /**
     * Test Add.
     */
    @Test
    public void whenAddStringToSimpleArray() {
        SimpleArray<String> arr = new SimpleArray<String>(1);
        arr.add("Test");
        String expected = "Test";
        String result = arr.get(0);
        assertThat(result, is(expected));
    }

    /**
     * Test Update.
     */
    @Test
    public void whenUpdateValueStringFromExistEntry() {
        SimpleArray<String> arr = new SimpleArray<String>(1);
        arr.add("Test");
        arr.update("Test", "Java");
        String result = arr.get(0);
        String expected = "Java";
        assertThat(result, is(expected));
    }

    /**
     * Test Delete.
     */
    @Test
    public void whenDeleteValueStringAndReturnNull() {
        SimpleArray<Integer> arr = new SimpleArray<Integer>(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.delete(1);
        Integer expected = 2;
        Integer result = arr.get(0);
        assertThat(result, is(expected));
    }

    /**
     * Test Get.
     */
    @Test
    public void whenAddValueTheGetHim() {
        SimpleArray<Integer> arr = new SimpleArray<Integer>(1);
        arr.add(1);
        Integer result = arr.get(0);
        Integer expected = 1;
        assertThat(result, is(expected));
    }

}
