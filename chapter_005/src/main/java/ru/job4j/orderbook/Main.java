package ru.job4j.orderbook;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Task Order Book.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */

public class Main {
    /**
     * Book - 1.
     */
    private List<String> book1 = new ArrayList<>();
    /**
     * Book - 2.
     */
    private List<String> book2 = new ArrayList<>();
    /**
     * Book - 3.
     */
    private List<String> book3 = new ArrayList<>();

    /**
     * Form and print final Book.
     *
     * @param file input file for parsing.
     * @throws FileNotFoundException exception.
     * @throws XMLStreamException    exception.
     */
    void formBook(String file) throws FileNotFoundException, XMLStreamException {
        Parser parser = new Parser();
        Map<Integer, Order> mapOrder = parser.fillOrders(file);
        Book book = new Book();
        book.divideOnOperation(mapOrder);
        book.sumVolume();
        book.calcBook();
        List<Order> buy = book.getBuy();
        List<Order> sell = book.getSell();

        for (int i = 0; i < buy.size(); ) {
            for (int j = 0; j < sell.size(); j++) {
                if (buy.get(i).book == sell.get(j).book && buy.get(i).book == 1) {
                    book1.add(buy.get(i).volume + "@" + buy.get(i).price + " - " + sell.get(i).volume + "@" + sell.get(i).price);
                    i++;
                    break;
                } else if (buy.get(i).book == sell.get(j).book && buy.get(i).book == 2) {
                    book2.add(buy.get(i).volume + "@" + buy.get(i).price + " - " + sell.get(i).volume + "@" + sell.get(i).price);
                    i++;
                    break;
                } else if (buy.get(i).book == sell.get(j).book && buy.get(i).book == 3) {
                    book3.add(buy.get(i).volume + "@" + buy.get(i).price + " - " + sell.get(i).volume + "@" + sell.get(i).price);
                    i++;
                    break;
                }

            }
        }

        System.out.println("Order book - 1");
        for (int i = 0; i < book1.size(); i++) {
            System.out.println(book1.get(i));
        }
        System.out.println("Order book - 2");
        for (int i = 0; i < book2.size(); i++) {
            System.out.println(book2.get(i));
        }
        System.out.println("Order book - 3");
        for (int i = 0; i < book3.size(); i++) {
            System.out.println(book3.get(i));
        }
    }
}


