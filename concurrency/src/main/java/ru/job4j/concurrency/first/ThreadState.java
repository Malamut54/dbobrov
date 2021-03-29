package ru.job4j.concurrency.first;

import java.lang.Thread.State;

public class ThreadState {

    public static void main(String[] args) {
        Thread first = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        Thread second = new Thread(() -> System.out.println(Thread.currentThread().getName()));

        first.start();
        second.start();

        while (true) {
            if (first.getState() == State.TERMINATED && second.getState() == State.TERMINATED) {
                System.out.println("Job complete");
                break;
            }
        }
    }
}
