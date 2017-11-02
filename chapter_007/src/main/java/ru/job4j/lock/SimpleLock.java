package ru.job4j.lock;

/**
 * Task Lock.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 02.11.2017
 */

public class SimpleLock {
    /**
     * Lock or unlock.
     */
    private boolean isLocked = false;

    /**
     * Method lock job.
     *
     * @throws InterruptedException exception.
     */
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    /**
     * Method unlock job.
     */
    public synchronized void unlock() {
        isLocked = false;
        notifyAll();
    }
}
