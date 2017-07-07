package ru.job4j.generic;

/**
 * Chapter Generic.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 06.07.2017
 */

/**
 * Class Simple Array.
 *
 * @param <E> Input Generic.
 */
public class SimpleArray<E> {
    /**
     * Private field.
     */
    private Object[] array;
    /**
     * Private filed.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param sizeArray - set size of array.
     */
    public SimpleArray(int sizeArray) {
        this.array = new Object[sizeArray];
    }

    /**
     * Add some value for array.
     * @param value - input value.
     */
    public void add(E value) {
        this.array[index++] = value;
    }

    /**
     * Update value from array.
     *
     * @param value    - value for change.
     * @param newValue - new value.
     */
    public void update(E value, E newValue) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(value)) {
                this.array[i] = newValue;
                break;
            }
        }
    }

    /**
     * Delete value from array.
     * @param value - value for delete.
     */
    public void delete(E value) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(value)) {
                System.arraycopy(this.array, i + 1, this.array, i, this.array.length - 1);
                this.array[array.length - 1] = null;
                this.index--;
                break;
            }
        }
    }

    /**
     * Get value at index.
     *
     * @param index - input index.
     * @return value.
     */
    public E get(int index) {
        return (E) this.array[index];
    }

    /**
     * Get array length.
     *
     * @return int.
     */
    public int length() {
        return this.array.length;
    }
}
