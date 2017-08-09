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
    private int count;

    public SimpleMap() {
        this.arrMap = new Node[16];
    }

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

    public V get(K key) {
        int index = indexFor(this.hash(key), this.arrMap.length);
        if (this.arrMap[index] != null) {
            return this.arrMap[index].getValue();
        } else {
            return null;
        }
    }

    public boolean delete(K key) {
        int index = indexFor(this.hash(key), this.arrMap.length);
        if (this.arrMap[index] != null) {
            this.arrMap[index] = null;
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
            if (arrTmp[i] != null) {
                insert(arrMap[i].getKey(), arrMap[i].getValue());
            }
        }

    }
    @Override
    public Iterator iterator() {
        return new SimpleMapIterator<K>();
    }

    private class SimpleMapIterator<K> implements Iterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }

    private class Node<K, V> {
        private final K key;
        private final V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
