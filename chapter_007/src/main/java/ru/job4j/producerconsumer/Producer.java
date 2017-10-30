package ru.job4j.producerconsumer;

/**
 * Task Producer Consumer.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 30.10.2017
 */

public class Producer implements Runnable {
    /**
     * Start value.
     */
    private Integer value = 0;
    /**
     * Timeout.
     */
    private Integer pause = 1000;
    /**
     * Link to buffer.
     */
    private Buffer buffer;

    /**
     * Constructor.
     *
     * @param buffer link to buffer.
     */
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {

            try {
                System.out.println(String.format("%d produced", value));
                buffer.add(this.value++);
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
