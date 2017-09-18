package ru.job4j.orderbook;

import java.util.Date;

/**
 * Task TO DO
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class Order {
    /**
     * Book number.
     */
    public final String book;
    /**
     * Buy or Sell.
     */
    public final String operation;
    /**
     * Price.
     */
    public final float price;
    /**
     * Number of item.
     */
    public final int volume;


    /**
     * @param book
     * @param operation
     * @param price
     * @param volume
     */
    public Order(String book, String operation, float price, int volume) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;

    }

}
