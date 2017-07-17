package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task List.
 *
 * @param <E>
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 13.07.2017
 */

public class ArrayContainer<E> implements SimpleContainer<E> {
    /**
     * private field.
     */
    private Object[] arrContainer;
    /**
     * Private field.
     */
    private int length;
    /**
     * Private field.
     */
    private int index;
    /**
     * Private field.
     */
    private int caretka = 0;

    /**
     * Getter for length array.
     *
     * @return int.
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Constructor create container with specified size.
     *
     * @param length specified size for container.
     */
    public ArrayContainer(int length) {
        if (length <= 0) {
            arrContainer = new Object[10];
            this.length = 10;
        } else {
            arrContainer = new Object[length];
            this.length = length;
        }
    }

    /**
     * Default Constructor, create container with default size 10.
     */
    public ArrayContainer() {
        this.length = 10;
        arrContainer = new Object[this.length];


    }

    /**
     * Add value to ArrayContainer.
     *
     * @param e vlue for add.
     */
    @Override
    public void add(E e) {
        if (length - 1 == this.index) {
            increaseSize();
        }
        arrContainer[this.index++] = e;

    }

    /**
     * Get value from ArrayContainer by index.
     *
     * @param index index.
     * @return value.
     */
    @Override
    public E get(int index) {
        E result = null;
        if (index > length && index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            result = (E) arrContainer[index];
        }
        return result;
    }

    /**
     * Iterator for ArrayContainer.
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayContainerIterator();
    }

    /**
     * Method increase capacity of ArrayContainer.
     */
    private void increaseSize() {
        int newSizeCont = (this.length * 3) / 2 + 1;
        Object[] tmp = new Object[newSizeCont];
        System.arraycopy(this.arrContainer, 0, tmp, 0, this.index);
        this.length = newSizeCont;
        this.arrContainer = tmp;
    }

    /**
     * Iterator for ArrayContainer.
     *
     * @param <E>
     */
    private class ArrayContainerIterator<E> implements Iterator<E> {


        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return caretka < getLength() && caretka < index;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (caretka >= getLength()) {
                throw new NoSuchElementException();
            }
            return (E) get(caretka++);
        }
    }
}
