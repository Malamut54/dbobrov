package ru.job4j.task1;

/**
 * Task 1.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 27.09.2017
 */

public class Main {
    /**
     * Main method.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        Counter counter = new Counter("   asd as dqw  ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.spaceCount();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.wordsCount();
            }
        }).start();

    }

}

