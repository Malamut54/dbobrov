package ru.job4j.pool;

import ru.job4j.producerconsumer.BlockingQueue;

/**
 * Task ThreadPool.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 01.11.2017
 *
 */

public class ThreadPool {
    /**
     * Store workers who do the work.
     */
    private PoolWorker[] threads;
    /**
     * Store tasks.
     */
    private BlockingQueue<Runnable> queue;

    /**
     * Default constructor.
     */
    public ThreadPool() {
        threads = new PoolWorker[Runtime.getRuntime().availableProcessors()];
        queue = new BlockingQueue(10);

        for (PoolWorker thread : threads) {
            thread = new PoolWorker();
            thread.start();
        }
    }

    /**
     * Add task to {@link BlockingQueue}.
     *
     * @param task input task.
     * @throws InterruptedException exception.
     */
    public void execute(Runnable task) throws InterruptedException {
        synchronized (queue) {
            queue.put(task);
        }
    }

    /**
     * Class create worker that does the work.
     */
    private class PoolWorker extends Thread {
        /**
         * Task.
         */
        private Runnable task;

        @Override
        public void run() {
            while (true) {
                try {
                    task = queue.take();
                } catch (InterruptedException e) {

                }
                try {
                    task.run();
                } catch (RuntimeException e) {

                }
            }
        }
    }
}
