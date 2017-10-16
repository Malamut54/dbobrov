package ru.job4j.task2;

import java.util.LinkedList;
import java.util.List;

/**
 * Task 2.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 03.10.2017
 */

public class Word extends Thread {
    /**
     * Count for words.
     */
    private int wordCount;
    /**
     * Array to count spaces and words.
     */
    private char[] tmpText;

    /**
     * Constructor.
     *
     * @param tmpText input text.
     */
    public Word(char[] tmpText) {
        this.tmpText = tmpText;
    }

    /**
     * Method calculate words in text.
     */
    @Override
    public void run() {
        List list = new LinkedList<>();
        if (tmpText[0] != ' ') {
            wordCount++;
        }
        for (int i = 1; i < tmpText.length; i++) {

            if (tmpText[i - 1] == ' ' && tmpText[i] != ' ') {
                wordCount++;
                list.add(tmpText[i]);
                if (isInterrupted()) {
                    System.out.println("Thread is interrupted");
                    break;
                }
            }
        }
        System.out.println(String.format("Words: %d", wordCount));
    }
}
