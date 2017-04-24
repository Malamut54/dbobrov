package ru.job4j.tracker;

/**
 * Created by Malamut on 4/21/2017.
 */
public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String comments;

    public Item(String id, String name, long created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }
}
