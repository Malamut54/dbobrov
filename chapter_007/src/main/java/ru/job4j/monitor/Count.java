package ru.job4j.monitor;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Multi Count.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 18.10.2017
 *
 */

@ThreadSafe
class Count implements Runnable {

    /**
     * value for count.
     */
    @GuardedBy("increment")
    private int val;

    /**
     * Increment and print value.
     */
    public synchronized void increment() {
        val++;
        System.out.println(val);
    }
    @Override
    public void run() {
        increment();
    }
}

/**
 * Demo class.
 */
class Demo {
    /**
     * Main method.
     * @param args input args.
     */
    public static void main(String[] args) {
        Count count = new Count();
        for (int i = 0; i < 10; i++) {
            new Thread(count).start();
        }
    }
}