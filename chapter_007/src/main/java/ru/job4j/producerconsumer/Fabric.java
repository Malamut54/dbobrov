package ru.job4j.producerconsumer;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 27.10.2017
 */

public class Fabric {
    private List<String> list = new LinkedList<>();
    private volatile int count;
    private int limit = 2;

    public void add(String str) {
        list.add("str");
        count++;
        System.out.println(String.format("Producer working, count is %d, limit is %d ", count, limit));
    }

    public void get() {
        list.remove(0);
        count--;
        System.out.println(String.format("Consumer working, count is %d, limit is %d", count, limit));
    }


    class Producer implements Runnable {
        @Override
        public void run() {
            while (count <= limit) {
                add("demo");
            }

        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (count > 0) {
                get();
            }
        }
    }
}
