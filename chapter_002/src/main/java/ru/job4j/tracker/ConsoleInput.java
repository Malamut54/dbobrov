package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Task Tracker.
 */
public class ConsoleInput implements Input {
    /**
     * Class ConsoleInput. Perform input fro console.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * IO.
     * @param question question.
     * @return user choice.
     */
    public String ask(String question) {
        System.out.println(question);
        return this.scanner.nextLine();
    }

    /**
     * Asking question and Controls menu item numbers.
     *
     * @param question
     * @param range
     * @return
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
