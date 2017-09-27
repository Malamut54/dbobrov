package ru.job4j.task1;

/**
 * Task 1.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 26.09.2017
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

    /**
     * Constructor.
     *
     * @param input string.
     */
    public Counter(String input) {
        this.tmpText = input.toCharArray();
    }

    /**
     * Counting spaces.
     */
    public void spaceCount() {
        for (int i = 0; i < tmpText.length; i++) {
            if (tmpText[i] == ' ') {
                space++;
            }
        }
        System.out.println(String.format("Spaces: %d", space));
    }

    /**
     * Counting words.
     */
    public void wordsCount() {
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