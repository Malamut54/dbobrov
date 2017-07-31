package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task Set.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 28.07.2017
 */

public class LinkedSetTest {
    /**
     * Simple Add.
     */
    @Test
    public void whenAddValueToLinkedSetWithoutDuplicate() {
        LinkedSet<Integer> linkedSet = new LinkedSet<>();
        boolean result = linkedSet.add(1);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Check duplicate.
     */
    @Test
    public void whenAddValueToLinkedSetWithDuplicate() {
        LinkedSet<Integer> linkedSet = new LinkedSet<>();
        linkedSet.add(1);
        boolean result = linkedSet.add(1);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    /**
     * Check remove when value is exist.
     */
    @Test
    public void whenDeleteExistValue() {
        LinkedSet<Integer> linkedSet = new LinkedSet<>();
        linkedSet.add(1);
        linkedSet.add(2);
        boolean result = linkedSet.remove(2);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Check remove when value isn't exist.
     */
    @Test
    public void whenDeleteNonExistValue() {
        LinkedSet<Integer> linkedSet = new LinkedSet<>();
        linkedSet.add(1);
        linkedSet.add(2);
        boolean result = linkedSet.remove(3);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    /**
     * Test iterator.
     */
    @Test
    public void testIterationInRealCondition() {
        Integer result = 0;
        LinkedSet<Integer> linkedSet = new LinkedSet<>();
        Iterator<Integer> iterator = linkedSet.iterator();
        for (int i = 0; i < 10; i++) {
            linkedSet.add(i);
        }
        while (iterator.hasNext()) {
            result = iterator.next();
        }
        Integer expected = 9;
        assertThat(result, is(expected));
    }
}
