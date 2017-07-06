package ru.job4j.generic;

import org.junit.Test;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 06.07.2017
 */

public class SImpeArrayTest {
    @Test
    public void whenAddStringToSimpleArray() {
        SimpleArray<String> arr = new SimpleArray<String>(1);
        String expected = "Test";
        String result = arr.get(0);

    }
}
