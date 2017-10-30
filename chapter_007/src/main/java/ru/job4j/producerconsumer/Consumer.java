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
    private Buffer buffer;

    /**
     * Constructor.
     *
     * @param buffer link to buffer.
     */
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer result = buffer.get();
                System.out.println(String.format("%d Consumed", result));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
