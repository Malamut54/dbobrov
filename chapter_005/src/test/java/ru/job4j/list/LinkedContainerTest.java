package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task List.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.07.2017
 */
public class LinkedContainerTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddValueToLinkedConatainer() {
        LinkedContainer<Integer> linkedList = new LinkedContainer<>();
        for (int i = 0; i < 6; i++) {
            linkedList.add(i);
        }
        Integer result = linkedList.get(4);
        Integer expected = 4;
        assertThat(result, is(expected));
    }

    /**
     * Test Iterator.
     */
    @Test
    public void testIteratorInRealCondition() {
        Integer result = null;
        LinkedContainer<Integer> linkedList = new LinkedContainer<>();
        for (int i = 0; i < 6; i++) {
            linkedList.add(i);
        }
        while (linkedList.iterator().hasNext()) {
            result = linkedList.iterator().next();
        }
        Integer expected = 5;
        assertThat(result, is(expected));

    }
}