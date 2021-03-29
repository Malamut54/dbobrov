package ru.job4j.concurrency.first;

public class ConcurrentOutput {

    public static void main(String[] args) {
        Thread firstThread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        Thread secondThread = new Thread(() -> System.out.println(Thread.currentThread().getName()));

        firstThread.start();
        secondThread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
