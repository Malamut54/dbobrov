package ru.job4j.nonblock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Task non blocking cache.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 08.11.2017
 * @param <K>
 * @param <V>
 */

public class Cache<K, V extends Model> {
    /**
     * Non Blocking cache.
     */
    private Map<K, V> cache = new ConcurrentHashMap<>();

    /**
     * Add.
     *
     * @param key   key.
     * @param value value.
     */
    public void add(K key, V value) {
        this.cache.putIfAbsent(key, value);
    }

    /**
     * Delete by key.
     * @param key key.
     */
    public void delete(K key) {
        cache.remove(key);
    }

    /**
     * Update value.
     *
     * @param key   key.
     * @param value value.
     * @return Value.
     * @throws OptimisticException Exception.
     */
    public V update(K key, V value) throws OptimisticException {
        return this.cache.computeIfPresent(key, (k, v) -> {
            if (v.getVersion() == value.getVersion()) {
                value.increment();
                return value;
            } else {
                throw new OptimisticException("Error when update");
            }
        });
    }

    /**
     * Get value by key.
     *
     * @param key key.
     * @return Value.
     */
    public V get(K key) {
        return this.cache.getOrDefault(key, null);
    }
}
