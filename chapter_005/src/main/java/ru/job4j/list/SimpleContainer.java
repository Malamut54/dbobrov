package ru.job4j.list;

/**
 * Task List.
 *
 * @param <E>
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 13.07.2017
 */

public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Method add.
     *
     * @param e value for add.
     */
    void add(E e);

    /**
     * Method return value.
     *
     * @param index input index.
     * @return value;
     */
    E get(int index);
}
