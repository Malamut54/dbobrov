package ru.job4j.nonblock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Task non blocking cache.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 08.11.2017
 */

public class Cache<K, V> {
    private Map<K, V> cache = new ConcurrentHashMap<>();

    public void add(K key, V value) {
        this.cache.putIfAbsent(key, value);
    }

    public void delete(K key) {
        this.cache.computeIfAbsent(key, )
    }
}
