package ru.job4j.tracker;

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
    private Item[] items = new Item[100];
    /**
     * Private fileds.
     */
    private int position = 0;
    /**
     * Private fileds.
     */
    private static final Random RN = new Random();

    /**
     * Add Item to array.
     * @param item item.
     * @return Item.
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
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
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Find Item by name.
     *
     * @param name input name.
     * @return Item.
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(name)) {
                result[count++] = this.items[i];
            }
        }
        return Arrays.copyOf(result, count);

    }

    /**
     * Delete Item from array.
     *
     * @param item input item for delete.
     */
    public void delete(Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].equals(item)) {
                this.items[i] = null;
            }
        }
    }

    /**
     * Update concrete item.
     *
     * @param item input item for update.
     */
    public void upddate(Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
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
