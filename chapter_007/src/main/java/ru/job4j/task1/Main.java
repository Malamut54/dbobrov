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
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter("   asd as dqw  ");
        System.out.println("start");
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.spaceCount();
                Thread spaceThread = Thread.currentThread();
                try {
                    spaceThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.wordsCount();
                Thread wordThread = Thread.currentThread();
            }
        }).start();
        Thread mainThread = Thread.currentThread();
        System.out.println("finish");

    }

}

