package ru.job4j.concurrency.fourth;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class CountBarrier {
    private final Object monitor = this;

    private final int total;

    @GuardedBy("this")
    private int count = 0;

    public CountBarrier(int total) {
        this.total = total;
    }


    public void count() {
        synchronized (monitor) {
            count++;
            monitor.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (monitor) {
            while (count < total) {
                monitor.wait();
            }
        }
    }
}
