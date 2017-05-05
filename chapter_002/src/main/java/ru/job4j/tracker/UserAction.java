package ru.job4j.tracker;

/**
 * Task Tracker.
 */
public interface UserAction {
    /**
     * Method determines the uniqueness of the key.
     * @return key
     */
    int key();

    /**
     * Perform actions.
     * @param input ask.
     * @param tracker Object Tracker.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Display menu items.
     * @return String menu item.
     */
    String info();
}
