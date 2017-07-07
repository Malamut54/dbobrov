package ru.job4j.generic;

/**
 * Task realization Store.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.07.2017
 * @param <T>
 */

public interface Store<T extends Base> {
    /**
     * Add.
     *
     * @param value Input value.
     */
    void add(T value);

    /**
     * Update.
     *
     * @param existValue value for change.
     * @param newValue   new value.
     */
    void update(T existValue, T newValue);

    /**
     * Delete.
     *
     * @param value value for delete.
     */
    void delete(T value);

    /**
     * Get.
     *
     * @param id Input String.
     * @return value.
     */
    T get(String id);
}
