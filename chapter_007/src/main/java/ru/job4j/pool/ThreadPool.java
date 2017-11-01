package ru.job4j.pool;

import ru.job4j.producerconsumer.BlockingQueue;

import java.util.List;

/**
 * Task ThreadPool.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 01.11.2017
 */

public class ThreadPool {
    private int noOfThreads = Runtime.getRuntime().availableProcessors();
    private BlockingQueue blockingQueue;
    private Worker[] threads = new Worker[noOfThreads];
    private boolean isStopped = false;

    public ThreadPool() {
        blockingQueue = new BlockingQueue();

        for (int i = 0; i < noOfThreads; i++) {
            threads[i] = new Worker(blockingQueue);
        }
        for (Worker thread : threads) {
            thread.start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception {
        if (this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        this.blockingQueue.put(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (Worker thread : threads) {
            thread.doStop();
        }
    }
}
