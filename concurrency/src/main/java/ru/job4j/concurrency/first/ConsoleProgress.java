package ru.job4j.concurrency.first;

import java.util.Arrays;
import java.util.List;

public class ConsoleProgress implements Runnable {
    private static final Integer UPDATE_TIMEOUT = 300;
    private static final Integer MAIN_TIMEOUT = 10000;
    private static final List<String> SYMBOLS = Arrays.asList("\\", "|", "/");

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                for (String symbol : SYMBOLS) {
                    Thread.sleep(UPDATE_TIMEOUT);
                    System.out.print("\r load: " + symbol);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(MAIN_TIMEOUT);
        progress.interrupt();
    }
}
