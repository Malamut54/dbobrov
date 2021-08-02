package ru.job4j.concurrency.fifth;

import java.util.concurrent.atomic.AtomicReference;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class CASCount {
    private final AtomicReference<Integer> count = new AtomicReference<>();

    public void increment() {
        while (true) {
            Integer currentValue = count.get();
            Integer newValue = currentValue + 1;
            if (count.compareAndSet(currentValue, newValue)) {
                return;
            }
        }
    }

    public int get() {
        return count.get();
    }
}
