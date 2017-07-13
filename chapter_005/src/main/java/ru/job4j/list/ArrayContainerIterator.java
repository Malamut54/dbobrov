package ru.job4j.list;

import java.util.Iterator;

/**
 * Task List.
 *
 * @param <E>
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 13.07.2017
 */

public class ArrayContainerIterator<E> implements Iterator<E> {
    /**
     * private field.
     */
    private ArrayContainer arr;
    /**
     * private field.
     */
    private int index = 0;

    /**
     * Default constructor.
     */
    public ArrayContainerIterator() {
    }

    /**
     * Constructor for Iterator.
     *
     * @param arr input ArrayContainer.
     */
    public ArrayContainerIterator(ArrayContainer arr) {
        this.arr = arr;
    }

    /**
     * Realization method hasNext.
     *
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return this.index++ < this.arr.getLength() && arr.get(this.index) != null;
    }

    /**
     * Realization method next.
     *
     * @return value.
     */
    @Override
    public E next() {
        return (E) arr.get(this.index);
    }
}
