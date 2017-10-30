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
     *
     * @param args args.
     */
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread consumer = new Thread(new Consumer(buffer));
        Thread producer = new Thread(new Producer(buffer));

        consumer.start();
        producer.start();

    }
}
