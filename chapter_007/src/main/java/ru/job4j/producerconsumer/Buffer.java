package ru.job4j.producerconsumer;


/**
 * Task Producer Consumer.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 27.10.2017
 */

public class Buffer {
    /**
     * Variable that stores the value.
     */
    private Integer value = null;

    /**
     * Method add.
     *
     * @param newValue value for store.
     * @throws InterruptedException exception.
     */
    public synchronized void add(Integer newValue) throws InterruptedException {
        while (value != null) {
            this.wait();
        }
        this.value = newValue;
        this.notifyAll();
    }

    /**
     * Get value and set variable value to null.
     *
     * @return value.
     * @throws InterruptedException exception.
     */
    public synchronized Integer get() throws InterruptedException {
        while (value == null) {
            this.wait();
        }
        Integer result = this.value;
        this.value = null;
        this.notifyAll();
        return result;

    }

}
