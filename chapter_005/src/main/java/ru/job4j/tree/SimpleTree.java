package ru.job4j.tree;

/**
 * Task tree.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.08.2017
 * @param <E>
 */

public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add child in parent.
     * Parent can have list of child
     *
     * @param parent input parent value.
     * @param child input child value.
     * @return boolean.
     */
    boolean add(E parent, E child);
}
