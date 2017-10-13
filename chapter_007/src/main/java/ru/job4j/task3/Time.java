package ru.job4j.task3;

/**
 * Task 3.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 12.10.2017
 */

public class Time implements Runnable {
    /**
     * Timer for waiting.
     */
    private int timer;

    /**
     * Constructor for timer.
     * @param timer setup timer.
     */
    public Time(int timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        Thread count = new Thread(new CountChar("asd asd asd asd"));
        count.start();
        try {
            count.join(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count.isAlive()) {
            System.out.println("Tired of waiting");
            count.interrupt();
        }

    }
}
