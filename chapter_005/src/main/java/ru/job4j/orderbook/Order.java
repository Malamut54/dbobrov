package ru.job4j.orderbook;

/**
 * Task TO DO
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class Order {
    /**
     * Book number.
     */
    public final int book;
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
    public Order(int book, String operation, float price, int volume) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;

    }

    @Override
    public String toString() {
        return volume + "@" + price + " " + "Book-" + book + operation;
    }

}
