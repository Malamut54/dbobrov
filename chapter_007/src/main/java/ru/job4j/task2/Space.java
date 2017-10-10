package ru.job4j.task2;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 03.10.2017
 */

public class Space extends Thread {
    /**
     * Count for spaces.
     */
    private int space;
    /**
     * Array to count spaces and words.
     */
    private char[] tmpText;

    Thread t;

    public Space(char[] tmpText) {
        this.tmpText = tmpText;
        t = new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < tmpText.length; i++) {
            if (tmpText[i] == ' ') {
                space++;
            }
        }
        System.out.println(String.format("Spaces: %d", space));
    }
}
