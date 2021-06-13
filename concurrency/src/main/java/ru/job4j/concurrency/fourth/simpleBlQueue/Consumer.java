package ru.job4j.concurrency.fourth.simpleBlQueue;

public class Consumer implements Runnable {
    private final SimpleBlockingQueue<Integer> simpleBlockingQueue;

    public Consumer(SimpleBlockingQueue<Integer> simpleBlockingQueue) {
        this.simpleBlockingQueue = simpleBlockingQueue;
    }

    @Override
    public void run() {
        try {
            Integer i = simpleBlockingQueue.poll();
            System.out.println("Get " + i + " from simpleBlockingQueue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
