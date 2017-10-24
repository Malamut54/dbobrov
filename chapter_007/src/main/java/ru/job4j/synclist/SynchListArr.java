package ru.job4j.synclist;

import java.util.Iterator;

/**
 * Task synchronize list.
 *
 * @param <E>
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class SynchListArr<E> {
    /**
     * Storage for element.
     */
    private Object[] array;
    /**
     * Length of array.
     */
    private int length;
    /**
     * count for add element.
     */
    private int count;
    /**
     * Carriage for iterator.
     */
    private int carriage;
    /**
     * Index for iterator.
     */
    private int index;

    /**
     * Default constructor with size = 10.
     */
    public SynchListArr() {
        this.length = 10;
        this.array = new Object[this.length];
    }

    /**
     * Constructor with alternate size.
     *
     * @param length input lenght for storage.
     */
    public SynchListArr(int length) {
        this.length = length;
        this.array = new Object[this.length];

    }

    /**
     * Add element for storage.
     *
     * @param element input element.
     */
    public synchronized void add(E element) {
        if (array.length - 1 == count) {
            increaseArray();
        }
        array[count++] = element;
        index++;
    }

    /**
     * Get element from storage.
     *
     * @param index get by index.
     * @return value.
     */
    public synchronized E get(int index) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) array[index];
        }
    }

    /**
     * Increase array capacity.
     */
    private void increaseArray() {
        this.length = length * 2;
        Object[] arrayTmp = new Object[this.length];
        System.arraycopy(this.array, 0, arrayTmp, 0, this.array.length - 1);
        this.array = arrayTmp;
    }

    /**
     * Constructor for Iterator.
     *
     * @return Iterator.
     */
    public synchronized Iterator<E> iterator() {
        return new SynchListIterator();
    }

    /**
     * Class Iterator.
     *
     * @param <E> value.
     */
    private class SynchListIterator<E> implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return carriage < index;
        }

        @Override
        public E next() {
            return (E) array[carriage++];
        }
    }
}

