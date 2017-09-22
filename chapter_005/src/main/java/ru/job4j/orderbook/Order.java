package ru.job4j.orderbook;

/**
 * Task Order Book.
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
     * @param book id book.
     * @param operation sell or buy.
     * @param price price.
     * @param volume volume.
     */
    public Order(int book, String operation, float price, int volume) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;

    }
}
