package ru.job4j.tracker;

/**
 * Task Tracker.
 */

/**
 * Class BaseAction. Display number and name menu items.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Private fields name.
     */
    private String name;
    /**
     * Private fields name.
     */
    private int key;

    /**
     * Constructor.
     *
     * @param name Name of the menu item.
     * @param key  Number of the menut item.
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    /**
     * Method Display number and name menu items.
     *
     * @return String.
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }

    /**
     * Determine the unique key.
     *
     * @return key.
     */
    public int key() {
        return this.key;
    }
}
