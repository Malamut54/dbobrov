package ru.job4j.trackerdb;


/**
 * Task Tracker.
 */
public class Item {
    /**
     * Private fields.
     */
    private int id;
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
     *
     * @param name name.
     * @param desc description.
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * Constructor for item with ID.
     *
     * @param id   id
     * @param name name
     * @param desc description
     */
    public Item(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    /**
     * Getter fot desc.
     *
     * @return desc.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Getter for id.
     *
     * @return id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter for name.
     *
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (id != item.id) {
            return false;
        }
        if (!name.equals(item.name)) {
            return false;
        }
        return desc.equals(item.desc);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + desc.hashCode();
        return result;
    }
}
