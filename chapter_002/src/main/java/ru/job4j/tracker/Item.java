package ru.job4j.tracker;

/**
 * Task Tracker.
 */
public class Item {
    /**
     * Class item, describe ticket.
     */

    /**
     * Private fields.
     */
    private String id;
    /**
     * Private fields.
     */
    private String name;
    /**
     * Private fields.
     */
    private String desc;
    /**
     * Private fields.
     */
    private long created;
    /**
     * Private fields.
     */
    private String comments;

    /**
     * Constructor for Item.
     * @param id id.
     * @param name name.
     * @param created created.
     */
    public Item(String id, String name, long created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    /**
     * Getter for id.
     * @return id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Getter for name.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for id.
     * @param id item.
     */
    public void setId(String id) {
        this.id = id;
    }
}
