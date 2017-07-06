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
    private int index = 0;

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
        return checkEven() != -1;
    }

    /**
     * Implementation of the method next.
     *
     * @return value from array.
     */
    @Override
    public Object next() {
        if (this.array.length > this.index) {
            return array[this.index++];
        } else {
            return new NoSuchElementException();
        }

    }

    /**
     * Check even numbers in array.
     *
     * @return index of even number.
     */
    public int checkEven() {
        while (this.index < array.length) {
            if (array[this.index] % 2 == 0) {
                return this.index;
            } else {
                this.index++;
            }
        }
        return -1;
    }
}
