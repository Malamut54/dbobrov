package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 26.07.2017
 */

public class ArraySet<E> implements Iterable<E> {
    private int size;
    private Object[] arrSet;
    private int pointer = 0;
    int index = 0;

    public ArraySet() {
        this.arrSet = new Object[10];
        this.size = 10;
    }

    public boolean add(E value) {
        if (size == 0) {
            arrSet[index++] = value;
            size++;
            return true;
        } else if (contains(value)) {
            return false;
        } else {
            arrSet[index++] = value;
            size++;
            return true;
        }
    }

    public void remove(E value) {
        for (int i = 0; i < this.size; i++) {
            if (arrSet[i].equals(value)) {
                System.arraycopy(this.arrSet, i + 1, this.arrSet, i, this.arrSet.length - 1);
                this.arrSet[arrSet.length - 1] = null;
                size--;
                break;
            }
        }
    }

    public boolean contains(E value) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (arrSet[i].equals(value)) {
                return true;
            }
        }
        return result;
    }

    private void increaseArr() {

    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private class ArraySetIterator<E> implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return pointer < size && size > 0;
        }

        @Override
        public E next() {
            return (E) arrSet[pointer++];
        }
    }
}
