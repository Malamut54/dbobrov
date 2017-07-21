package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task List.
 *
 * @param <E>
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.07.2017
 */

public class LinkedContainer<E> implements SimpleContainer<E> {
    /**
     * Private field.
     */
    private Node<E> first;
    /**
     * Private field.
     */
    private Node<E> last;
    /**
     * Private field.
     */
    private int length = 0;
    /**
     * Private field.
     */
    private int counter = 0;

    /**
     * Default constructor. Create last and first node with value == null.
     */
    public LinkedContainer() {
        last = new Node<E>(null, first, null);
        first = new Node<E>(null, null, last);
    }

    /**
     * Method add.
     *
     * @param value for add.
     */
    @Override
    public void add(E value) {
        Node<E> prev = last;
        prev.item = value;
        last = new Node<E>(null, prev, null);
        prev.next = last;
        length++;
    }

    /**
     * Method return value.
     *
     * @param index input index.
     * @return value;
     */
    @Override
    public E get(int index) {
        Node<E> node;
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        } else if (length / 2 > index) {
            node = first.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last.prev;
            for (int i = 0; i < this.length - index - 1; i++) {
                node = node.prev;
            }
        }
        return node.item;
    }

    /**
     * Iterator for LinkedContainer.
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedContainerIterator<>();
    }

    /**
     * Iterator for LinkedContainer.
     * @param <E>
     */
    private class LinkedContainerIterator<E> implements Iterator<E> {
        /**
         * Realization method hasNext().
         * @return if the iteration has more elements.
         */
        @Override
        public boolean hasNext() {
            return counter < length && length != 0;
        }

        /**
         * Realization method next().
         * @return the next element in the iteration.
         */
        @Override
        public E next() {
            if (counter >= length) {
                throw new NoSuchElementException();
            }
            return (E) get(counter++);
        }
    }

    /**
     * Getter for counter.
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     * Class realizing Node.
     * @param <E>
     */
    private class Node<E> {
        /**
         * Private field.
         */
        private E item;
        /**
         * Private field.
         */
        private Node<E> next;
        /**
         * Private field.
         */
        private Node<E> prev;

        /**
         * Constructor.
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
