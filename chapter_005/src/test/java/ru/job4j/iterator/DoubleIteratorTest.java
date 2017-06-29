package ru.job4j.iterator;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Task Double Iterator
 *
 * @author dbobrov
 * @since 29.06.2017
 */

public class DoubleIteratorTest {
    public static final class ForEachDoubleArray implements Iterable {
        private final int[][] array;

        public ForEachDoubleArray(final int[][] array) {
            this.array = array;
        }

        @Override
        public Iterator iterator() {
            return new DoubleIterator(this.array);
        }
    }
    @Test
    public void whenGetNextCallShouldPointerForward() {
        DoubleIterator dit = new DoubleIterator(new int[][] {{1, 3}, {4, 5}});
        dit.next();
        dit.next();
        int result =(Integer) dit.next();
        assertThat(result, is(4));
    }
    @Test
    public void whenCheckNextPositionShouldReturnConstatntvalue() {
        DoubleIterator dit = new DoubleIterator(new int[][] {{1, 3}, {4, 5}});
        for (int i = 0; i < 4; i++) {
            dit.next();
        }
        boolean result = dit.hasNext();
        assertThat(result, is(false));
    }
    @Test
    public void foreach() {
        ForEachDoubleArray foreach = new ForEachDoubleArray(new int[][] {{1, 3}, {4, 5}});

        for (Object o : foreach) {
            System.out.println(o);
        }
    }
}
