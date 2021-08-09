package ru.job4j.concurrency.fifth.cache;

public class OptimisticException extends RuntimeException {

    public OptimisticException(String message) {
        super(message);
    }
}
