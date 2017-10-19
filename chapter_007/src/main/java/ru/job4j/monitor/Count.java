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
class Count {

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

}

/**
 * Demo class.
 */
class Demo implements Runnable {
    /**
     * Object count.
     */
    private Count count = new Count();

    @Override
    public void run() {
        count.increment();
    }

    /**
     * Main method.
     * @param args input args.
     */
    public static void main(String[] args) {
        Demo demo = new Demo();
        for (int i = 0; i < 10; i++) {
            new Thread(demo).start();
        }
    }
}