package ru.job4j.orderbook;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Task Order Book.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */

public class Main {

    /**
     * Form and print final Book.
     *
     * @param file input file for parsing.
     * @throws FileNotFoundException exception.
     * @throws XMLStreamException    exception.
     */
    public void formBook(String file) throws FileNotFoundException, XMLStreamException {
        Parser parser = new Parser();

        Map<Integer, Order> mapOrder = parser.fillOrders(file);
        OrderSplit orderSplit = new OrderSplit(mapOrder);
        Map<Integer, Book> orderBook = orderSplit.split();
        for (Map.Entry<Integer, Book> entry : orderBook.entrySet()) {
            printBook(entry.getKey(), entry.getValue().getSell(), entry.getValue().getBuy());
        }
    }

    /**
     * Print Book.
     *
     * @param book num of books.
     * @param sell sell.
     * @param buy  price.
     */
    void printBook(Integer book, Map<Float, Integer> sell, Map<Float, Integer> buy) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Book %d\n", book));
        for (Map.Entry<Float, Integer> entry : sell.entrySet()) {
            builder.append(String.format("SELL \t\t%5s %7s\n", entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<Float, Integer> entry : buy.entrySet()) {
            builder.append(String.format("BUY \t\t%5s %7s\n", entry.getKey(), entry.getValue()));
        }
        System.out.println(builder);
    }
}


