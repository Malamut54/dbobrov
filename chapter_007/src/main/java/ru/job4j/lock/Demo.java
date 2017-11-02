package ru.job4j.lock;

/**
 * Task Lock.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 02.11.2017
 */

public class Demo implements Runnable {
    /**
     * Class field.
     */
    private Increment incr = new Increment();

    @Override
    public void run() {
        try {
            incr.increment();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main method.
     *
     * @param args input args.
     */
    public static void main(String[] args) {
        Demo demo = new Demo();
        for (int i = 0; i < 10; i++) {
            new Thread(demo).start();
        }
    }
}

/**
 * Demonstrate SimpleLock.
 */
class Increment {
    /**
     * value for increment.
     */
    private int i;
    /**
     * Realization SimpleLock.
     */
    private SimpleLock lock = new SimpleLock();

    /**
     * Method increment the value.
     *
     * @throws InterruptedException exception.
     */
    public void increment() throws InterruptedException {
        lock.lock();
        i++;
        Thread.sleep((int) (Math.random() * 100));
        System.out.println(i);
        lock.unlock();
    }
}
