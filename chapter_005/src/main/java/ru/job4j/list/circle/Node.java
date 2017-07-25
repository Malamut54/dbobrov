package ru.job4j.list.circle;

/**
 * Task Cycle.
 *
 * @param <T>
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.07.2017
 */

public class Node<T> {
    /**
     * The value stored in Node.
     */
    private T value;
    /**
     * Pointer to the next Node.
     * Should be private, but for tasks it is not critical.
     */
    Node<T> next;

    /**
     * Constructor which creates Node with value.
     *
     * @param value for store in the Node.
     */
    public Node(T value) {
        this.value = value;
    }
}
