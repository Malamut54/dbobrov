package ru.job4j.concurrency.first;

public class Wget {

    private static final Integer TIMEOUT = 1000;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(TIMEOUT);
                    System.out.print("\rLoading : " + i + "%");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

}
