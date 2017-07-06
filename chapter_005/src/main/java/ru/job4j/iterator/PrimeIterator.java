package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for prime number.
 *
 * @author dbobrov
 * @since 03.07.2017
 */

public class PrimeIterator implements Iterator {
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
     * @param array input array.
     */
    public PrimeIterator(int[] array) {
        this.array = array;
    }

    /**
     * Implementation method hasNext for prime number.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return checkPrime() != -1;
    }

    /**
     * Implemenatation method next for prime number.
     * @return prime number.
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
     * Check prime number in array.
     * @return index of prime number.
     */
    private int checkPrime() {
        while (this.index < array.length) {
            if (this.array[this.index] < 2) {
                this.index++;
                return -1;
            }
            for (int i = 2; i * i <= this.array[this.index]; i++) {
                if (this.array[this.index] % i == 0) {
                    this.index++;
                    return -1;
                }
            }
            return this.index;
        }
        return -1;
    }
}
