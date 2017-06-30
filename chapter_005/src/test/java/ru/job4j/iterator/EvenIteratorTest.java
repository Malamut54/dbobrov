package ru.job4j.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Iterator of even numbers.
 *
 * @author dbobrov
 * @since 30.06.2017
 */

public class EvenIteratorTest {

    /**
     * Test method next().
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        EvenIterator eit = new EvenIterator(new int[]{0, 3, 4, 6, 1, 6});
        eit.next();
        int result = (Integer) eit.next();
        assertThat(result, is(4));
    }

    /**
     * Test method hasNext().
     */
    @Test
    public void whenCheckNextPositionShouldReturnConstatntvalue() {
        EvenIterator eit = new EvenIterator(new int[]{0, 3, 4, 6, 1, 1});
        for (int i = 0; i < 6; i++) {
            eit.next();
        }
        boolean result = eit.hasNext();
        assertThat(result, is(false));
    }

}
