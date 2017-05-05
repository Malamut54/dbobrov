package ru.job4j.tracker;

/**
 * Task Tracker.
 */
public class StartUI {
    /**
     * Class StartUI. Perform logic app.
     */

    /**
     *  Private fields.
     */
    private Input input;
    /**
     *  Private fields.
     */
    private Tracker tracker;


    /**
     * Constructor for StartUI.
     * @param tracker tracker.
     * @param input input.
     */
    public StartUI(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }


    /**
     * Method that processes user requests.
     */
    public void init() {
        MenutTracker menu = new MenutTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select: ", menu.rangekey()));
        } while (!"y".equals(this.input.ask("Exit? y ")));

    }

    /**
     * Entry point.
     * @param args args.
     */
    public static void main(String[] args) {
        StartUI start = new StartUI(new Tracker(), new ValidateInput());
        start.init();
    }
}
