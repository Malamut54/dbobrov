package ru.job4j.list;

/**
 * Task List.
 *
 * @param <E>
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 21.07.2017
 */

public interface SimpleStackContainer<E> {
    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed onto this stack.
     */
    void push(E item);

    /**
     * Removes the object at the top of this stack and
     * returns that objects as the value.
     *
     * @return The object at the top of this stack.
     */
    E pop();
}
