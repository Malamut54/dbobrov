package ru.job4j.trackerDB;

//
///**
// * Task Tracker.
// */
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

}
