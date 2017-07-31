package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task Set.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 28.07.2017
 * @param <E>
 */

public class LinkedSet<E> implements Iterable<E> {
    /**
     * First node.
     */
    private Node<E> first;
    /**
     * Last node.
     */
    private Node<E> last;
    /**
     * Counts the numbers of node with value.
     */
    private int length;

    /**
     * Default constructor.
     */
    public LinkedSet() {
        last = new Node<E>(null, first, null);
        first = new Node<E>(null, null, last);
    }

    /**
     * Add value.
     *
     * @param value input value.
     * @return boolean.
     */
    public boolean add(E value) {
        if (contains(value)) {
            return false;
        } else {
            Node<E> prev = last;
            prev.item = value;
            last = new Node<E>(null, prev, null);
            prev.next = last;
            this.length++;
            return true;
        }
    }

    /**
     * Check contains a value in linkedSet.
     * @param value input value.
     * @return boolean.
     */
    public boolean contains(E value) {
        Iterator<E> linkedSetIter = iterator();
        while (linkedSetIter.hasNext()) {
            if (value.equals(linkedSetIter.next())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove value from linkedSet.
     *
     * @param value input value.
     * @return boolean.
     */
    public boolean remove(E value) {
        if (first.next.equals(last)) { // Empty set
            return false;
        } else {
            Node rmNode = first.next;
            while (rmNode != this.last) {
                if (rmNode.item.equals(value)) {
                    rmNode.prev.next = rmNode.next;
                    rmNode.next.prev = rmNode.prev;
                    rmNode.next = null;
                    rmNode.prev = null;
                    this.length--;
                    return true;
                } else {
                    rmNode = rmNode.next;
                }
            }
            return false;
        }
    }

    /**
     * Iterator for LinkedSet.
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedSetIterator<E>();
    }

    /**
     * Realization Iterator.
     * @param <E>
     */
    private class LinkedSetIterator<E> implements Iterator<E> {
        /**
         * Pointer to first node.
         */
        private Node node = first;
        /**
         * Counter.
         */
        private int counter;

        /**
         * Realization hasNext.
         * @return boolean.
         */
        @Override
        public boolean hasNext() {
            return counter < length && length != 0;
        }

        /**
         * Realization next.
         * @return value.
         */
        @Override
        public E next() {
            if (counter >= length) {
                throw new NoSuchElementException();
            }
            node = node.next;
            counter++;
            return (E) node.item;
        }
    }

    /**
     * Class realizing Node.
     *
     * @param <E>
     */
    private class Node<E> {
        /**
         * Value for store.
         */
        private E item;
        /**
         * Pointer to next node.
         */
        private Node<E> next;
        /**
         * Pointer to previous node.
         */
        private Node<E> prev;

        /**
         * Constructor.
         *
         * @param item value.
         * @param prev previous node.
         * @param next nex node.
         */
        Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
