package ru.job4j.producerconsumer;


import java.util.LinkedList;
import java.util.List;


/**
 * Task Producer Consumer.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 27.10.2017
 * @param <E>
 */

public class BlockingQueue<E> {
    /**
     * Blocking queue.
     */
    private List<E> queue = new LinkedList<>();
    /**
     * Size of queue.
     */
    private int limit = 3;

    /**
     * Constructor that sets size of the queue.
     *
     * @param limit set size.
     */
    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    /**
     * Default constructor.
     */
    public BlockingQueue() {
    }

    /**
     * Put element in queue.
     *
     * @param element input element.
     * @throws InterruptedException exception.
     */
    public synchronized void put(E element) throws InterruptedException {
        while (this.queue.size() == limit) {
            System.out.println("Failure Queue is full");
            wait();
        }
        if (this.queue.size() == 0) {
            System.out.println("Queue is empty. Method put Ready to job");
            notifyAll();
        }
        this.queue.add(element);
    }

    /**
     * Take element from queue.
     *
     * @return value
     * @throws InterruptedException exception
     */
    public synchronized E take() throws InterruptedException {
        while (this.queue.size() == 0) {
            System.out.println("Don't ready to job, because queue is empty");
            wait();
        }
        if (this.queue.size() == limit) {
            System.out.println("Queue is full, method take ready to job");
            notifyAll();
        }
        return this.queue.remove(0);
    }
}
