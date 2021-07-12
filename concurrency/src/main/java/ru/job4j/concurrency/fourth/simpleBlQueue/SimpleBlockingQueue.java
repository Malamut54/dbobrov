package ru.job4j.concurrency.fourth.simpleBlQueue;

import java.util.LinkedList;
import java.util.Queue;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();
    private final int sizeLimit;

    public SimpleBlockingQueue(int sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    public synchronized void offer(T value) throws InterruptedException {
        while (sizeLimit == queue.size()) {
            this.wait();
        }
        queue.offer(value);
        this.notify();
    }

    public synchronized T poll() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        this.notify();
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
