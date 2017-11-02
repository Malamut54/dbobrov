package ru.job4j.pool;

/**
 * Task ThreadPool.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 02.11.2017
 */

public class Demo {
    /**
     * Main method.
     *
     * @param args input args.
     * @throws InterruptedException exception.
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();

        for (int i = 0; i < 20; i++) {
            Task task = new Task(i);
            threadPool.execute(task);
        }
    }

    /**
     * Class imitating a task.
     */
    static class Task implements Runnable {
        /**
         * Number of task.
         */
        private int num;

        /**
         * Constructor specifying task number.
         *
         * @param num input num.
         */
        Task(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println(String.format("Task %d is running", num));
        }
    }
}
