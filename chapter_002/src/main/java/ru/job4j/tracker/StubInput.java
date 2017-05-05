package ru.job4j.tracker;

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
     * Asking question and Controls menu item numbers.
     *
     * @param question
     * @param range
     * @return
     */
//    public int ask(String question, int[] range) {
////        throw new UnsupportedOperationException("Unsupported operation");
//        return -1;
//    }

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
//    public String ask(String question) {
//        return answers[position++];
//    }
    public String ask(String question) {
        for (int i = 0; i < answers.length; i++) {
            return answers[i];
        }
        return answers[answers.length - 1];
    }

}
