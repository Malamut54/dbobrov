package ru.job4j.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Task Double Iterator.
 *
 * @author dbobrov
 * @since 29.06.2017
 */

public class DoubleIteratorTest {
    /**
     * Test method next().
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        DoubleIterator dit = new DoubleIterator(new int[][] {{1, 3}, {4, 5}});
        dit.next();
        dit.next();
        int result = (Integer) dit.next();
        assertThat(result, is(4));
    }

    /**
     * Test method hasNext().
     */
    @Test
    public void whenCheckNextPositionShouldReturnConstatntvalue() {
        DoubleIterator dit = new DoubleIterator(new int[][] {{1, 3}, {4, 5}});
        for (int i = 0; i < 4; i++) {
            dit.next();
        }
        boolean result = dit.hasNext();
        assertThat(result, is(false));
    }
}
