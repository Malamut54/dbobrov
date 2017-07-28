package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 28.07.2017
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

    public boolean contains(E value) {
        Iterator<E> linkedSetIter = iterator();
        while (linkedSetIter.hasNext()) {
            if (value.equals(linkedSetIter.next())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedSetIterator<E>();
    }

    private class LinkedSetIterator<E> implements Iterator<E> {
        Node node = first;
        int counter;

        @Override
        public boolean hasNext() {
            return counter < length && length != 0;
        }

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
