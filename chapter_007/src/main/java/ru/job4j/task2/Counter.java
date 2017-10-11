package ru.job4j.task2;

import java.util.Date;

/**
 * Task 2.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 03.10.2017
 */

public class Counter {

    /**
     * Array to count spaces and words.
     */
    private char[] tmpText;
    /**
     * Thread space.
     */
    private Thread space;
    /**
     * Thread word.
     */
    private Thread word;
    /**
     * Time execution.
     */
    private long timeExec;
    /**
     * limit timer.
     */
    private int timer = 1000;

    /**
     * Constructor.
     *
     * @param input string.
     */
    public Counter(String input) {
        this.tmpText = input.toCharArray();
        start();
    }

    /**
     * Start Threads and check limit timer.
     */
    void start() {
        spaceCount();
        wordsCount();
        try {
            long start = new Date().getTime();
            space.join();
            word.join();
            long finish = new Date().getTime();
            timeExec = (finish - start);
            if (timeExec > timer) {
                space.interrupt();
                word.interrupt();
            }
            System.out.println("The end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Counting spaces.
     */
    public void spaceCount() {
        Space space = new Space(tmpText);
        this.space = new Thread(space);
        this.space.start();


    }

    /**
     * Counting words.
     */
    public void wordsCount() {
        Word word = new Word(tmpText);
        this.word = new Thread(word);
        this.word.start();


    }


}
