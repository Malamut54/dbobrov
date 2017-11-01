package ru.job4j.producerconsumer;

/**
 * Task Producer Consumer.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 30.10.2017
 */

public class Demo {
    /**
     * Main method.
     * @param args input args.
     * @throws InterruptedException exception.
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue buffer = new BlockingQueue();
        for (int i = 0; i < 10; i++) {
            new Thread(new Producer(buffer)).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(buffer)).start();
        }

    }
}
