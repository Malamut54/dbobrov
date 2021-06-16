package ru.job4j.concurrency.fourth.simpleBlQueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class SimpleBlockingQueueTest {

    @Test
    public void simpleBlockingQueueDemonstrate() throws InterruptedException {
        SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<>(2);

        Thread consumer = new Thread(new Consumer(simpleBlockingQueue));
        Thread producer = new Thread(new Producer(simpleBlockingQueue));

        consumer.start();
        producer.start();

        consumer.join();
        producer.join();


    }
}