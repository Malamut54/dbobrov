package ru.job4j.trackerdb;

import java.util.ArrayList;

/**
 * Task Tracker.
 */
public class StubInput extends ValidateInput implements Input {
    /**
     * Class Stubinput. Provide data entry.
     */

    /**
     * Private field.
     */
    private String[] answers;
    /**
     * Private field.
     */
    private int position = 0;

    /**
     * Constructor.
     *
     * @param answers answers.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Method return answers.
     *
     * @param question input.
     * @return answers.
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * Method for testing exceptions.
     *
     * @param question question.
     * @param range    range.
     * @return key or exception.
     */
    public int ask(String question, ArrayList<Integer> range) {
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
