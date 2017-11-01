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
    private Integer value = (int) (Math.random() * 100);
    /**
     * Link to buffer.
     */
    private BlockingQueue buffer;

    /**
     * Constructor.
     *
     * @param buffer link to buffer.
     */
    public Producer(BlockingQueue buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            System.out.println(String.format("Try to Put value %d in Queue", value));
            buffer.put(this.value);
            System.out.println(String.format("%d success put", value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
