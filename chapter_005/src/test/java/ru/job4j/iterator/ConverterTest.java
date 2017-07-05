package ru.job4j.iterator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task Iterator Of Iterator.
 *
 * @author dbobrov
 * @since 05.07.2017
 */

public class ConverterTest {
    /**
     * Test method next.
     */
    @Test
    public void whenItHasThreeInnerIt() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(2).iterator(),
                Collections.singletonList(3).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        int result = convert.next();
        assertThat(result, is(2));
    }

    /**
     * Test method hasNext when return false.
     */
    @Test
    public void whenCheckIteratorOfIteratorReturnFalse() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(2).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        convert.next();
        boolean result = convert.hasNext();
        assertThat(result, is(false));
    }

    /**
     * Test method hasNext when return true.
     */
    @Test
    public void whenCheckIteratorOfIteratorReturnTrue() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(2).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        boolean result = convert.hasNext();
        assertThat(result, is(true));
    }
}
