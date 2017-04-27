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
}
