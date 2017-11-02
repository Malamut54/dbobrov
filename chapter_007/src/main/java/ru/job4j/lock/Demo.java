package ru.job4j.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 02.11.2017
 */

public class Demo implements Runnable {
    Incr incr = new Incr();

    @Override
    public void run() {
        incr.increment();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        for (int i = 0; i < 10; i++) {
            new Thread(demo).start();
        }
    }
}

class Incr {
    private int i;

    public void increment() {
        i++;
        System.out.println(i);
    }
}
