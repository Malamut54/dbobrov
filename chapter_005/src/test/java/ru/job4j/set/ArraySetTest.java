package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task Set.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 27.07.2017
 */

public class ArraySetTest {
    /**
     * Simple Add.
     */
    @Test
    public void whenAddValueToArraySetWithoutDuplicate() {
        ArraySet<Integer> arrSet = new ArraySet<Integer>();
        boolean result = arrSet.add(1);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Check duplicate.
     */
    @Test
    public void whenAddValueToArraySetWithDuplicate() {
        ArraySet<Integer> arrSet = new ArraySet<Integer>();
        arrSet.add(1);
        boolean result = arrSet.add(1);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    /**
     * Check increase array.
     */
    @Test
    public void whenAddValueToArraySetAndIncreaseIt() {
        ArraySet<Integer> arrSet = new ArraySet<Integer>();
        for (int i = 0; i < 11; i++) {
            arrSet.add(i);
        }
        boolean result = arrSet.add(11);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Check remove.
     */
    @Test
    public void whenDelExistValueFromArray() {
        ArraySet<Integer> arrSet = new ArraySet<Integer>();
        arrSet.add(1);
        arrSet.add(2);
        boolean result = arrSet.remove(2);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Test iterator.
     */
    @Test
    public void testIterationInRealCondition() {
        Integer result = 0;
        ArraySet<Integer> arrSet = new ArraySet<>();
        Iterator<Integer> iterator = arrSet.iterator();
        for (int i = 0; i < 10; i++) {
            arrSet.add(i);
        }
        while (iterator.hasNext()) {
            result = iterator.next();
        }
        Integer expected = 9;
        assertThat(result, is(expected));
    }
}
