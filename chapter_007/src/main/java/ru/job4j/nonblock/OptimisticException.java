package ru.job4j.nonblock;

/**
 * Task non blocking cache.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 08.11.2017
 */

public class OptimisticException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param message Error message.
     */
    public OptimisticException(String message) {
        super(message);
    }
}
