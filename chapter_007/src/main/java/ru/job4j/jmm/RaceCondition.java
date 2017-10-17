package ru.job4j.jmm;

/**
 * Demonstrate Race Condition.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 17.10.2017
 */

public class RaceCondition {
    /**
     * Shared variable.
     */
    private int val = 0;

    /**
     * Create two Threads.
     */
    void run() {
        //Check parity
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (val % 2 == 0) {
                        System.out.println("Even = " + val);
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //Increment value
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    val++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

/**
 * Demo class.
 */
class RaceConditionDemo {
    /**
     * Main method.
     * @param args input args
     */
    public static void main(String[] args) {
        RaceCondition raceCondition = new RaceCondition();
        raceCondition.run();
    }
}