package ru.job4j.concurrency.fourth.simpleBlQueue;

import java.util.Random;

public class Producer implements Runnable {
    private final SimpleBlockingQueue<Integer> simpleBlockingQueue;

    public Producer(SimpleBlockingQueue<Integer> simpleBlockingQueue) {
        this.simpleBlockingQueue = simpleBlockingQueue;
    }

    @Override
    public void run() {
        try {
            int i = new Random().nextInt();
            System.out.println("Put " + i + " in simpleBlockingQueue" );
            simpleBlockingQueue.offer(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
