package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Task Double Iterator
 *
 * @author dbobrov
 * @since 28.06.2017
 */

public class DoubleIterator implements Iterator {

    private final int[][] array;
    private int table;
    private int row ;
    int countIndex;


    public DoubleIterator(int[][] array) {
        this.array = array;
    }


    @Override
    public boolean hasNext() {
        boolean a = array.length * array[row].length > countIndex;
        return a;
    }

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
