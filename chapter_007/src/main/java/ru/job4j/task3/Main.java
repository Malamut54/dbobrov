package ru.job4j.task3;

/**
 * Task 3.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 13.10.2017
 */

public class Main {
    /**
     * Stsrt program.
     * @param args input args.
     */
    public static void main(String[] args) {
        Thread time = new Thread(new Time(100));
        time.start();
    }
}
