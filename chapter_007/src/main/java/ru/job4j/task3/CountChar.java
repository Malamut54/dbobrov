package ru.job4j.task3;

/**
 * Task 3.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 12.10.2017
 */

public class CountChar implements Runnable {
    /**
     * Array.
     */
    private char[] text;
    /**
     * Count for char.
     */
    private int count;

    /**
     * Constructor.
     * @param str input String.
     */
    public CountChar(String str) {
        this.text = str.toCharArray();
    }

    @Override
    public void run() {
        for (int i = 0; i < text.length; i++) {
            if (text[i] != ' ') {
                count++;
            }
            if (Thread.interrupted()) {
                System.out.println("Thread interrupted");
            }
        }
        System.out.println(String.format("Number of characters in a string: %d", count));
    }
}
