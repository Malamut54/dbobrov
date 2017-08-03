package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task List.
 *
 * @param <E>
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */

public class OptimizedArraySet<E> implements Iterable<E> {
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
    private int count;

    /**
     * Default constructor. Create Array.
     */
    public OptimizedArraySet() {
        this.arrSet = new Object[16];
        this.size = 16;
    }

    /**
     * Return index of array.
     * Stolen from source HashMap.
     *
     * @param h      Input hashCode.
     * @param length of array.
     * @return index.
     */
    private int indexFor(int h, int length) {
        return h & (length - 1);
    }

    /**
     * Hash over Object.hashCode().
     * Stolen from source HashMap.
     *
     * @param key input value.
     * @return hash over hashCode().
     */
    private int hash(E key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Add value.
     *
     * @param value input value.
     * @return boolean.
     */
    public boolean add(E value) {
        if (this.count == arrSet.length) {
            increaseArr();
        }
        int index = indexFor(this.hash(value), this.size);
        if (arrSet[index] == null) {
            arrSet[index] = value;
            this.count++;
            return true;
        } else if (arrSet[index] != null && !arrSet[index].equals(value)) {
            for (int i = 0; i < size; i++) {
                if (arrSet[i] == null) {
                    arrSet[i] = value;
                    this.count++;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Increase size of array.
     */
    private void increaseArr() {
        int newSizeCont = this.size * 2;
        Object[] tmp = new Object[newSizeCont];
        System.arraycopy(this.arrSet, 0, tmp, 0, this.size);
        this.size = newSizeCont;
        this.arrSet = tmp;
    }

    /**
     * Iterator OptimizedArraySet.
     *
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new OptimizedArraySetIterator<E>();
    }

    /**
     * Realization Iterator.
     *
     * @param <E>
     */
    private class OptimizedArraySetIterator<E> implements Iterator<E> {
        /**
         * Pointer.
         */
        private int pointer;

        /**
         * Realization hasNext.
         *
         * @return boolean.
         */
        @Override
        public boolean hasNext() {
            return pointer < size;
        }

        /**
         * Realization next.
         *
         * @return value.
         */
        @Override
        public E next() {
            if (pointer >= size) {
                throw new NoSuchElementException();
            }
            return (E) arrSet[pointer++]; //also returns null!
        }
    }

}
