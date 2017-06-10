package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Task Tracker.
 */
public class Tracker {
    /**
     *Class Tracker. Provides basic functions when working with request.
     */

    /**
     * Private array for storing tickets.
     */
    private ArrayList<Item> items = new ArrayList<Item>();

    /**
     * Private fileds.
     */
    private static final Random RN = new Random();

    /**
     * Add Item to array.
     *
     * @param item item.
     * @return Item.
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Search for an ticket by ID.
     *
     * @param id input id.
     * @return Item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Return all tickets.
     *
     * @return array conaining all tickets.
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = (ArrayList<Item>) this.items.clone();
        return result;
    }

    /**
     * Find Item by name.
     *
     * @param name input name.
     * @return Item.
     */
    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> result = new ArrayList<Item>();
        for (Item item : this.items) {
            if (name.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;

    }

    /**
     * Delete Item from array.
     *
     * @param item input item for delete.
     */
    public void delete(Item item) {

        for (Item itemForDel : this.items) {
            if (itemForDel.getId().equals(item.getId())) {
                this.items.remove(itemForDel);
                break;
            }
        }
    }

    /**
     * Update concrete item.
     *
     * @param item input item for update.
     */
    public void upddate(Item item) {
        for (Item itemForUpd : this.items) {
            if (itemForUpd.getId().equals(item.getId())) {
                this.items.remove(itemForUpd);
                this.items.add(item);
                break;
            }
        }
    }

    /**
     * Generate unique id for each Item.
     *
     * @return generate id.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}