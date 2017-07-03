package ru.job4j.iterator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Iterator for prime number.
 *
 * @author dbobrov
 * @since 03.07.2017
 */

public class PrimeIteratorTest {

    /**
     * Test method next().
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        PrimeIterator pit = new PrimeIterator(new int[]{91, 97, 101, 151});
        pit.next();
        int result = (Integer) pit.next();
        assertThat(result, is(97));
    }

    /**
     * Test method hasNext().
     */
    @Test
    public void whenCheckNextPositionShouldReturnConstantValue() {
        PrimeIterator pit = new PrimeIterator(new int[]{91, 97, 101, 151});
        for (int i = 0; i < 4; i++) {
            pit.next();
        }
        boolean result = pit.hasNext();
        assertThat(result, is(false));
    }

    /**
     * Test method isPrime.
     */
    @Test
    public void whenCheckPrimeNumberShouldReturnTrue() {
        PrimeIterator pit = new PrimeIterator(new int[]{1});
        boolean result = pit.isPrime(101);
        assertThat(result, is(true));
    }

    /**
     * Test method isPrime.
     */
    @Test
    public void whenCheckPrimeNumberShouldReturnFalse() {
        PrimeIterator pit = new PrimeIterator(new int[]{1});
        boolean result = pit.isPrime(91);
        assertThat(result, is(false));
    }

}