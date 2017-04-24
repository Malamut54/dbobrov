package ru.job4j.tracker;

/**
 * Created by Malamut on 4/23/2017.
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int countId = 0;

    public Item add(Item item) {
        return this.items[countId++] = item;
    }


}
