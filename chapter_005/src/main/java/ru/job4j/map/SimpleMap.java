package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple Map.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 08.08.2017
 * @param <K>
 * @param <V>
 */

public class SimpleMap<K, V> implements Iterable<K> {
    /**
     * Node for store key and value.
     */
    private Node<K, V>[] arrMap;
    /**
     * Count of storef elements.
     */
    private int count;

    /**
     * Default constructor.
     */
    public SimpleMap() {
        this.arrMap = new Node[16];
    }

    /**
     * Return index of array.
     * Stolen from source HashMap.
     *
     * @param h      Input hashCode.
     * @param length of array.
     * @return index.
     */
    private int indexFor(int h, int length) {
        return h & (length - 1);
    }

    /**
     * Hash over Object.hashCode().
     * Stolen from source HashMap.
     *
     * @param key input value.
     * @return hash over hashCode().
     */
    private int hash(K key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Insert pair key/value to array.
     *
     * @param key   input key.
     * @param value input value
     * @return boolean.
     */
    public boolean insert(K key, V value) {
        if (count == arrMap.length) {
            increaseArr();
        }
        int index = indexFor(this.hash(key), this.arrMap.length);
        if (this.arrMap[index] == null) {
            this.arrMap[index] = new Node<>(key, value);
            count++;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Returns the value at the key.
     * @param key input key.
     * @return value.
     */
    public V get(K key) {
        int index = indexFor(this.hash(key), this.arrMap.length);
        if (this.arrMap[index] != null) {
            return this.arrMap[index].getValue();
        } else {
            return null;
        }
    }

    /**
     * Delete node by the key.
     * @param key input key.
     * @return boolean.
     */
    public boolean delete(K key) {
        int index = indexFor(this.hash(key), this.arrMap.length);
        if (this.arrMap[index] != null) {
            this.arrMap[index] = null;
            count--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Increase size of array.
     */
    private void increaseArr() {
        Node<K, V>[] newArr = new Node[arrMap.length * 2];
        Node<K, V>[] arrTmp = this.arrMap;
        this.arrMap = newArr;
        this.count = 0;
        for (int i = 0; i < arrTmp.length; i++) {
            insert(arrTmp[i].getKey(), arrTmp[i].getValue());
        }

    }

    /**
     * Iterator for SimpleMap.
     * @return iterator.
     */
    @Override
    public Iterator iterator() {
        return new SimpleMapIterator<V>();
    }

    /**
     * Realization Iterator.
     *
     * @param <V>
     */
    private class SimpleMapIterator<V> implements Iterator {
        /**
         * Pointer.
         */
        private int pointer = 0;

        /**
         * Realization hasNext.
         * @return boolean.
         */
        @Override
        public boolean hasNext() {
            return pointer < arrMap.length && pointer < count;
        }

        /**
         * Realization next.
         * @return value.
         */
        @Override
        public Object next() {
            if (pointer >= arrMap.length || pointer >= count) {
                throw new NoSuchElementException();
            }
            while (true) {
                if (arrMap[pointer] == null) {
                    pointer++;
                } else {
                    return arrMap[pointer++].getValue();
                }
            }
        }
    }

    /**
     * Class Node for store key and value.
     * @param <K>
     * @param <V>
     */
    private class Node<K, V> {
        /**
         * Key.
         */
        private final K key;
        /**
         * Value.
         */
        private final V value;

        /**
         * Constructor.
         *
         * @param key   input key.
         * @param value input value.
         */
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Getter for key.
         * @return key.
         */
        public K getKey() {
            return key;
        }

        /**
         * Getter for value.
         * @return value.
         */
        public V getValue() {
            return value;
        }
    }
}
