package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Task List.
 *
 * @param <E>
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.07.2017
 */
public class QueueContainer<E> {
    /**
     * Private filed.
     */
    private LinkedContainer<E> linkedContainer = new LinkedContainer();

    /**
     * Add value at the end of queue.
     * @param value value.
     */
    public void offer(E value) {
        linkedContainer.add(value);
    }

    /**
     * Return an element from the beginning of the queue
     * with deletion. If Queue is empty Generate NoSuchElementException.
     * @return value.
     */
    public E remove() {
        E result;
        if (linkedContainer.getLength() == 0) {
            throw new NoSuchElementException();
        } else {
            result = linkedContainer.getFirst();
        }
        linkedContainer.removeFirst();
        return result;

    }

    /**
     * Return an element from the beginning of the queue
     * with deletion. If Queue is empty return null.
     * @return value.
     */
    public E poll() {
        E result;
        if (linkedContainer.getLength() == 0) {
            return null;
        } else {
            result = linkedContainer.getFirst();
        }
        linkedContainer.removeFirst();
        return result;
    }

    /**
     * Return an element from the beginning of the queue without deletion
     * If Queue is empty Generate NoSuchElementException.
     * @return value.
     */
    public E element() {
        E result;
        if (linkedContainer.getLength() == 0) {
            throw new NoSuchElementException();
        } else {
            result = linkedContainer.getFirst();
        }
        return result;
    }
    /**
     * Return an element from the beginning of the queue without deletion
     * If Queue is empty return null.
     * @return value.
     */
    public E peek() {
        E result;
        if (linkedContainer.getLength() == 0) {
            return null;
        } else {
            result = linkedContainer.getFirst();
        }
        return result;
    }
}
