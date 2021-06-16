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
        while (sizeLimit >= queue.size()) {
            System.out.println("Queue is full, send wait()");
            this.wait();
        }
        queue.offer(value);
        System.out.println("SimpleBlockingQueue receive " + value + " from producer");
        this.notifyAll();
    }

    public synchronized T poll() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty, send wait()");
            this.wait();
        }
        return queue.poll();
    }
}
