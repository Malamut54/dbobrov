package ru.job4j.producerconsumer;

/**
 * Task Producer Consumer.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 30.10.2017
 */

public class Consumer implements Runnable {
    /**
     * Link to buffer.
     */
    private BlockingQueue buffer;

    /**
     * Constructor.
     *
     * @param buffer link to buffer.
     */
    public Consumer(BlockingQueue buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
            try {
                System.out.println("Try to take value from Queue");
                Object result = (Integer) buffer.take();
                System.out.println(String.format("%d Consumed", result));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
