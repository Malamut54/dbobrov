package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Task Double Iterator.
 *
 * @author dbobrov
 * @since 28.06.2017
 */

public class DoubleIterator implements Iterator {
    /**
     * Private field.
     */
    private final int[][] array;
    /**
     * Private field.
     */
    private int table;
    /**
     * Private field.
     */
    private int row;
    /**
     * Private field.
     */
    private int countIndex;

    /**
     * Constructor for array.
     *
     * @param array Input array.
     */
    public DoubleIterator(int[][] array) {
        this.array = array;
    }

    /**
     * Implementation of the method hasNext.
     *
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return array.length * array[row].length > countIndex;
    }

    /**
     * Implementation of the method next.
     * @return value from array.
     */
    @Override
    public Object next() {
        for (int i = 0; i < array.length; i++) {
            if (array[row].length <= table) {
                row++;
                table = 0;
            }
        }
        countIndex++;
        return array[row][table++];
    }
}
