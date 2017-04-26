package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Task Tracker.
 */
public class ConsoleInput implements Input{
    private Scanner scanner = new Scanner(System.in);

      public String ask(String question) {
        System.out.println(question);
        return this.scanner.nextLine();
    }

}
