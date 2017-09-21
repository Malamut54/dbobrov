package ru.job4j.orderbook;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 21.09.2017
 */

public class Main {
    List<Order> buy;
    List<Order> sell;


    void formBook(String file) throws FileNotFoundException, XMLStreamException {
        Parser parser = new Parser();
        Map<Integer, Order> mapOrder = parser.fillOrders(file);
        Book book = new Book();
        book.divideOnOperation(mapOrder);
        book.sumVolume();
        book.calcBook();
        this.buy = book.getBuy();
        this.sell = book.getSell();


    }
}


