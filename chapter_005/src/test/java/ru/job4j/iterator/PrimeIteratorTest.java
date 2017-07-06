package ru.job4j.iterator;

import org.junit.Assert;
import org.junit.Test;


/**
 * Iterator for prime number.
 *
 * @author dbobrov
 * @since 03.07.2017
 */

public class PrimeIteratorTest {

    /**
     * Test prime iterator.
     */
    @Test
    public void testPrimeIteratorInRealCondition() {
        int[] expected = (new int[]{2, 3, 5, 7, 11});
        int[] result = new int[5];
        PrimeIterator pit = new PrimeIterator(new int[]{1, 2, 3, 5, 7, 11, 12});
        for (int i = 0; i < result.length; ) {
            if (pit.hasNext()) {
                result[i] = (int) pit.next();
                i++;
            }
        }
        Assert.assertArrayEquals(expected, result);
    }
}