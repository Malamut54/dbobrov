package ru.job4j.tree;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.08.2017
 */

public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add child in parent.
     * Parent can have list of child
     *
     * @param parent
     * @param child
     * @return
     */
    boolean add(E parent, E child);
}
