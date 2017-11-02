package ru.job4j.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 02.11.2017
 */

public class Demo {

    public static void main(String[] args) {
        Counter counter = new Counter();
        List<Thread> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        counter.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).start();
        }
    }


}

class Counter {
    private int number = 0;
    SimpleLock simpleLock = new SimpleLock();

    public void increment() throws InterruptedException {
//        simpleLock.lock();
        System.out.println(number++);
//        simpleLock.unlock();
    }
}
