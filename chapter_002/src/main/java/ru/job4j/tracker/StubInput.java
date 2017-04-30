package ru.job4j.tracker;

/**
 * Task Tracker.
 */
public class StubInput implements Input {
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
     * @param answers answers.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Method return answers.
     * @param question input.
     * @return answers.
     */
    public String ask(String question) {
        return answers[position++];
    }
}
