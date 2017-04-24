package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Malamut on 4/23/2017.
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

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

    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position  ; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

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

    public void delete(Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].equals(item)) {
                this.items[i] = null;
            }
        }
    }

    public void upddate(Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
            }
        }
    }

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }


}
