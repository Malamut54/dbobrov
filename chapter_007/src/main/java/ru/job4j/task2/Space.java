package ru.job4j.task2;

/**
 * Task 2.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 03.10.2017
 */

public class Space extends Thread {
    /**
     * Count for spaces.
     */
    private int spaceCount;
    /**
     * Array to count spaces and words.
     */
    private char[] tmpText;

    /**
     * Constructor.
     *
     * @param tmpText input text.
     */
    public Space(char[] tmpText) {
        this.tmpText = tmpText;
    }

    /**
     * Method calculate spaces in text.
     */
    @Override
    public void run() {
        for (int i = 0; i < tmpText.length; i++) {
            if (tmpText[i] == ' ') {
                spaceCount++;
            }
            if (isInterrupted()) {
                System.out.println("Thread is interrupted");
                break;
            }
        }
        System.out.println(String.format("Spaces: %d", spaceCount));
    }
}
