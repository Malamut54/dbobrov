package ru.job4j.trackerdb;

import java.util.ArrayList;

/**
 * Task Tracker.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Asking question and Controls menu item numbers.
     *
     * @param question question.
     * @param range    range.
     * @return trows.
     */
    @Override
    public int ask(String question, ArrayList<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data again.");
            }
        } while (invalid);
        return value;
    }
}
