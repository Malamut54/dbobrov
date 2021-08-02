package ru.job4j.concurrency.fifth;

import java.util.concurrent.atomic.AtomicReference;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class CASCount {
    private final AtomicReference<Integer> count = new AtomicReference<>();

    public CASCount() {
        count.getAndSet(0);
    }

    public void increment() {
        int currentValue;
        int newValue;
        do {
            currentValue = count.get();
            newValue = currentValue + 1;
        } while (!count.compareAndSet(currentValue, newValue));
    }

    public int get() {
        return count.get();
    }
}
