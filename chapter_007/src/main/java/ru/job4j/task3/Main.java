package ru.job4j.task3;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 13.10.2017
 */

public class Main {
    public static void main(String[] args) {
        Thread time = new Thread(new Time());
        time.start();
    }
}
