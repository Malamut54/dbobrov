package ru.job4j.tracker;

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
//        this.items[countId++] = item;
        this.items[position] = item;
        position++;
        return item;
    }
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int i = 0; i != this.position  ; i++) {
            result[i] = this.items[i];
        }
        return result;
    }
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }


}
