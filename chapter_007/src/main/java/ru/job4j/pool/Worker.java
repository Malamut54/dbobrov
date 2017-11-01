package ru.job4j.pool;

import ru.job4j.producerconsumer.BlockingQueue;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 01.11.2017
 */

public class Worker extends Thread {
    private BlockingQueue blockingQueue;
    private boolean isStopped = false;

    public Worker(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (!isStopped()) {
            try {
                Runnable runnable = (Runnable) blockingQueue.take();
                run();
            } catch (InterruptedException e) {

            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}
