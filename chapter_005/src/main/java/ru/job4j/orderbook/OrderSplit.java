package ru.job4j.orderbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 05.10.2017
 */

public class OrderSplit {
    private Map<Integer, Order> list;
    private Map<Integer, Book> splitOrder = new HashMap<>();

    public OrderSplit(Map<Integer, Order> list) {
        this.list = list;
    }

    public Map<Integer, Book> split() {
        List<Order> listOfOSrcOrder = new ArrayList<>(list.values());
        List<Order> tmp = new ArrayList<>();

        //Fill splitOrder by key, value - empty.
        for (Order order : listOfOSrcOrder) {
            splitOrder.put(order.book, null);
        }
        for (Integer numOfBook : splitOrder.keySet()) {
            for (Order order : listOfOSrcOrder) {
                if (numOfBook == order.book) {
                    tmp.add(order);
                }
            }
            Book book = new Book();
            book.splitByOperation(tmp);
            splitOrder.put(numOfBook, book);
        }
        return splitOrder;
    }

}
