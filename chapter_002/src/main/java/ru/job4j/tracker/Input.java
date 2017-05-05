package ru.job4j.tracker;

/**
 * Task Tracker.
 */
public interface Input {
    /**
     *  Interface Input.
     */

    /**
     * Asking question.
     * @param question input.
     * @return output.
     */
    String ask(String question);

    /**
     * Asking question and Controls menu item numbers.
     *
     * @param question
     * @param range
     * @return
     */
    int ask(String question, int[] range);
}
