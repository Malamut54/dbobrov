package ru.job4j.generic;

/**
 * Task realization Store.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.07.2017
 * @param <T>
 */

public class AbstractStore<T extends Base> implements Store<T> {
    /**
     * Private fields.
     */
    private SimpleArray<T> arr = new SimpleArray<T>(10);

    /**
     * Add value to store.
     */
    @Override
    public void add(T value) {
        arr.add(value);
    }

    /**
     * Update value from store.
     *
     * @param existValue exist value.
     * @param newValue   new value.
     */
    @Override
    public void update(T existValue, T newValue) {
        arr.update(existValue, newValue);
    }

    /**
     * Delete value from store.
     *
     * @param value value for delete.
     */
    @Override
    public void delete(T value) {
        arr.delete(value);
    }

    /**
     * Get value from store.
     * @param id Id of value.
     * @return value.
     */
    @Override
    public T get(String id) {
        int size = arr.length();
        T result = null;
        for (int i = 0; i < size; ) {
            if (arr.get(i) == null) {
                i++;
            } else if (arr.get(i).getId().equals(id)) {
                result = arr.get(i);
                i++;
                return result;
            }
        }
        return result;
    }
}
