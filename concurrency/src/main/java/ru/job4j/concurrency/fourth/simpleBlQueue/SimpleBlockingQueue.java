package ru.job4j.concurrency.fourth.simpleBlQueue;

import java.util.LinkedList;
import java.util.Queue;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    public synchronized void offer(T value) {
        queue.offer(value);
        System.out.println("SimpleBlockingQueue receive " + value + " from producer");
        this.notifyAll();
    }

    public synchronized T poll() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty, send wait()");
            this.wait();
        }
        return queue.peek();
    }
}
