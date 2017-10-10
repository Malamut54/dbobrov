package ru.job4j.task2;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 03.10.2017
 */

public class Counter {
    /**
     * Count for spaces.
     */
    private int space;
    /**
     * Count for words.
     */
    private int word;
    /**
     * Array to count spaces and words.
     */
    private char[] tmpText;

    Thread s;
    Thread w;

    /**
     * Constructor.
     *
     * @param input string.
     */
    public Counter(String input) {
        this.tmpText = input.toCharArray();
        start();
    }

    void start() {
        spaceCount();
        wordsCount();
        try {
            s.join();
            w.join();
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
        s = new Thread(space);
        s.start();


    }

    /**
     * Counting words.
     */
    public void wordsCount() {
        Word word = new Word(tmpText);
        w = new Thread(word);
        w.start();


    }


}
