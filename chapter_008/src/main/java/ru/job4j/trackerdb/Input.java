package ru.job4j.trackerdb;

import java.util.ArrayList;

/**
 * Task Tracker.
 */
public interface Input {
    /**
     *  Interface Input.
     */

    /**
     * Asking question.
     *
     * @param question input.
     * @return output.
     */
    String ask(String question);

    /**
     * Asking question and Controls menu item numbers.
     *
     * @param question question.
     * @param range    range.
     * @return return.
     */
    int ask(String question, ArrayList<Integer> range);
}
