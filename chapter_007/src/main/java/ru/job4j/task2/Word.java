package ru.job4j.task2;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 03.10.2017
 */

public class Word extends Thread {
    /**
     * Count for words.
     */
    private int word;
    /**
     * Array to count spaces and words.
     */
    private char[] tmpText;
    Thread t;


    public Word(char[] tmpText) {
        this.tmpText = tmpText;
        Thread t = new Thread(this);
    }

    @Override
    public void run() {
        if (tmpText[0] != ' ') {
            word++;
        }
        for (int i = 1; i < tmpText.length; i++) {

            if (tmpText[i - 1] == ' ' && tmpText[i] != ' ') {
                word++;
            }
        }
        System.out.println(String.format("Words: %d", word));
    }
}
