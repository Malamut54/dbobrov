package ru.job4j.concurrency.fourth.simpleBlQueue;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;
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

    @Test
    public void whenFetchAllThenGetIt() throws Exception {
        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(10);
        Thread producer = new Thread(
            () -> {
                IntStream.range(0, 5).forEach(x ->
                    {
                        try {
                            queue.offer(x);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                );
            }
        );
        producer.start();
        Thread consumer = new Thread(
            () -> {
                while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                    try {
                        buffer.add(queue.poll());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        );
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();

        assertThat(buffer).isEqualTo(Arrays.asList(0, 1, 2, 3, 4));
    }
}