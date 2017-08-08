package ru.job4j.map;

import java.util.Iterator;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 08.08.2017
 */

public class SimpleMap<K, V> implements Iterable<K> {
    private Node<K, V>[] arrMap;
    private int index;

    public SimpleMap() {
        this.arrMap = new Node[16];
    }

    private boolean insert(K key, V value) {

        return false;
    }

    private V get(K key) {
        V result = null;

        return result;
    }

    private boolean delete(K key) {

        return false;
    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private class Node<K, V> {
        private K key;
        private V value;
    }
}
