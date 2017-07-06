package ru.job4j.iterator;

import org.junit.Assert;
import org.junit.Test;


/**
 * Iterator of even numbers.
 *
 * @author dbobrov
 * @since 30.06.2017
 */

public class EvenIteratorTest {

    /**
     * Test even Iterator.
     */
    @Test
    public void testEvenIteratorInRealCondition() {
        int[] expected = (new int[]{0, 4, 6, 0, 0, 0});
        int[] result = new int[6];
        EvenIterator eit = new EvenIterator(new int[]{0, 3, 4, 6, 1, 1});
        for (int i = 0; i < result.length; i++) {
            if (eit.hasNext()) {
                result[i] = (int) eit.next();
            }
        }
        Assert.assertArrayEquals(expected, result);
    }

}
