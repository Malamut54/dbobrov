package ru.job4j.concurrency.fourth.simpleBlQueue;

public class ParallelSearch {
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>(3);
        final Thread consumer = new Thread(
            () -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Integer poll = queue.poll();
                        if (poll != null) {
                            System.out.println(poll);
                        } else {
                            Thread.currentThread().interrupt();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        );
        consumer.start();

        new Thread(
            () -> {
                for (int index = 0; index != 3; index++) {
                    try {
                        queue.offer(index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        ).start();
    }
}
