package ru.job4j.concurrency.sixth;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import ru.job4j.concurrency.fourth.simpleBlQueue.SimpleBlockingQueue;

public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(Runtime.getRuntime().availableProcessors());
    private volatile boolean onWork = true;

    public ThreadPool() {
        int size = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < size; i++) {
            threads.add(new Thread(() -> {
                while (onWork) {
                    try {
                        tasks.poll().run();
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            }));
        }
        threads.forEach(Thread::start);
    }


    public void work(Runnable job) throws InterruptedException {
        if (!onWork) {
            throw new RejectedExecutionException();
        }
        tasks.offer(job);
    }

    public void shutdown() {
        onWork = false;
        threads.forEach(Thread::interrupt);
    }

}
