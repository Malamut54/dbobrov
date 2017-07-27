package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task Set.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 26.07.2017
 * @param <E>
 */

public class ArraySet<E> implements Iterable<E> {
    /**
     * Size of ArraySet.
     */
    private int size;
    /**
     * Array, used to store data.
     */
    private Object[] arrSet;
    /**
     * Count of stored elements.
     */
    private int index = 0;

    /**
     * Default constructor. Create Array.
     */
    public ArraySet() {
        this.arrSet = new Object[10];
        this.size = 10;
    }

    /**
     * Add value.
     *
     * @param value input value.
     * @return boolean.
     */
    public boolean add(E value) {
        if (this.size == this.index) {
            increaseArr();
        }
        if (this.index == 0) {
            arrSet[index++] = value;
            return true;
        } else if (contains(value)) {
            return false;
        } else {
            arrSet[index++] = value;
            return true;
        }
    }

    /**
     * Remove value.
     *
     * @param value input value for delete.
     * @return boolean.
     */
    public boolean remove(E value) {
        for (int i = 0; i < this.size; i++) {
            if (contains(value)) {
                System.arraycopy(this.arrSet, i + 1, this.arrSet, i, this.size - 1 - i);
                this.arrSet[this.size - 1] = null;
                this.index--;
                return true;
            }
        } return false;
    }

    /**
     * Check contains a value in array.
     * @param value input value.
     * @return boolean.
     */
    public boolean contains(E value) {
        boolean result = false;
        for (int i = 0; i < this.index; i++) {
            if (arrSet[i].equals(value)) {
                return true;
            }
        }
        return result;
    }

    /**
     * Increase size of array.
     */
    private void increaseArr() {
        int newSizeCont = (this.size * 3) / 2 + 1;
        Object[] tmp = new Object[newSizeCont];
        System.arraycopy(this.arrSet, 0, tmp, 0, this.index);
        this.size = newSizeCont;
        this.arrSet = tmp;
    }

    /**
     * Iterator for ArraySet.
     * @return iterator.
     */
    @Override
    public Iterator iterator() {
        return new ArraySetIterator();
    }

    /**
     * Realization Iterator.
     * @param <E>
     */
    private class ArraySetIterator<E> implements Iterator<E> {
        /**
         * Pointer.
         */
        private int pointer;

        /**
         * Realization hasNext.
         * @return boolean.
         */
        @Override
        public boolean hasNext() {
            return pointer < size && pointer < index;
        }

        /**
         * Realization next.
         * @return value.
         */
        @Override
        public E next() {
            if (pointer >= size) {
                throw new NoSuchElementException();
            }
            return (E) arrSet[pointer++];
        }
    }
}
