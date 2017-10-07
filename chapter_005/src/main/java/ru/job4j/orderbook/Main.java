package ru.job4j.orderbook;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        List<String> buyList = new ArrayList<>();
        List<String> sellList = new ArrayList<>();
        List<String> listFinal = new ArrayList<>();
        listFinal.add(String.format("Book %d\n", book));
        for (Map.Entry<Float, Integer> entry : sell.entrySet()) {
            sellList.add(String.format("%.1f@%d", entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<Float, Integer> entry : buy.entrySet()) {
            buyList.add(String.format("%.1f@%d", entry.getKey(), entry.getValue()));
        }
        int dummy = buyList.size() - sellList.size();
        if (dummy > 0) {
            for (int i = 0; i < dummy; i++) {
                sellList.add("------------");
            }
        } else if (dummy < 0) {
            for (int i = 0; i < Math.abs(dummy); i++) {
                buyList.add("------------");
            }
        }

        for (int i = 0; i < sellList.size(); i++) {
            listFinal.add(String.format(sellList.get(i) + "\t" + buyList.get(i)));
        }
        for (int i = 0; i < listFinal.size(); i++) {
            System.out.println(listFinal.get(i));
        }
        ;
    }
}


