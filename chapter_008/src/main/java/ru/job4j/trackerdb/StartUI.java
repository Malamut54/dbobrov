package ru.job4j.trackerdb;

/**
 * Task Tracker.
 */
public class StartUI {

    /**
     * Private fields.
     */
    private Input input;
    /**
     * Private fields.
     */
    private Tracker tracker;
    /**
     * private field.
     */
    private ConnectDB connectDB;


    /**
     * Constructor for StartUI.
     *
     * @param tracker   tracker.
     * @param input     input.
     * @param connectDB connect to DB.
     */
    public StartUI(Tracker tracker, Input input, ConnectDB connectDB) {
        this.tracker = tracker;
        this.input = input;
        this.connectDB = connectDB;
    }


    /**
     * Method that processes user requests.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select: ", menu.rangekey()));
        } while (!"y".equals(this.input.ask("Exit? y ")));

    }

    /**
     * Entry point.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        StartUI start = new StartUI(new Tracker(), new ValidateInput(), new ConnectDB());
        start.init();
    }
}
