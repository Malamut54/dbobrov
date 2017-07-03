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
        while (this.index < array.length) {
            if (isPrime(array[this.index])) {
                return true;
            } else {
                this.index++;
            }
        }
        return this.index <= array.length - 1;
    }

    /**
     * Implemenatation method next for prime number.
     * @return prime number.
     */
    @Override
    public Object next() {
        if (this.index <= array.length - 1) {
            return this.array[this.index++];
        } else {
            return new NoSuchElementException();
        }

    }

    /**
     * Check if the input number is prime.
     *
     * @param n input number.
     * @return boolean.
     */
    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
