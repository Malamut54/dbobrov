package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator of even numbers.
 *
 * @author dbobrov
 * @since 30.06.2017
 */

public class EvenIterator implements Iterator {
    /**
     * Private field.
     */
    private final int[] array;
    /**
     * Private field.
     */
    private int index;

    /**
     * Constructor for array.
     *
     * @param array Input array.
     */
    public EvenIterator(int[] array) {
        this.array = array;
    }

    /**
     * Implementation of the method hasNext.
     *
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        for (int i = 0; this.index < array.length; i++) {
            if (array[this.index] % 2 == 0) {
                return true;
            } else {
                for (int j = this.index; this.index < array.length; j++) {
                    if (array[this.index] % 2 != 0) {
                        this.index++;
                    } else {
                        return true;
                    }
                }
            }
        }
        return array.length > index;
    }

    /**
     * Implementation of the method next.
     *
     * @return value from array.
     */
    @Override
    public Object next() {
        for (int i = 0; this.index < array.length; ) {
            if (array[this.index] % 2 == 0) {
                return array[this.index++];
            } else {
                this.index++;
            }
        }
        return new NoSuchElementException();
    }
}
