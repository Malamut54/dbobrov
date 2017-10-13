package ru.job4j.task3;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 12.10.2017
 */

public class Time implements Runnable {
    private int timer = 100;
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        Thread count = new Thread(new CountChar("asd asd asd asd"));
        count.start();
        try {
            count.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long execTime = System.currentTimeMillis() - startTime;
        if (execTime > timer) {
            System.out.println("Tired of waiting");
            count.interrupt();
        }

    }
}
