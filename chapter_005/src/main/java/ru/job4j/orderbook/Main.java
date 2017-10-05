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
     * Formed Book.
     */
    Map<Integer, List<String>> resultBook = new TreeMap<>();

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
        OrderSplit orderSplit = new OrderSplit(mapOrder);
        orderSplit.split();


//        book.divideOnOperation(mapOrder);
//        book.sumVolume();
//        book.calcBook();
//        List<Order> buy = book.getBuy();
//        List<Order> sell = book.getSell();

//        for (int i = 0; i < buy.size(); i++) {
//            for (int j = 0; j < sell.size(); j++) {
//                if (buy.get(i).book == sell.get(j).book) {
//                    if (resultBook.containsKey(buy.get(i).book)) {
//                        List<String> tmp = resultBook.get(buy.get(i).book);
//                        tmp.add(String.format("%d@%.1f - %d@%.1f", buy.get(i).volume, buy.get(i).price,
//                                sell.get(j).volume, sell.get(j).price));
//                        sell.remove(j);
//                        break;
//                    } else {
//                        List<String> tmp = new ArrayList<>();
//                        tmp.add((String.format("Book - %d%nBID ASK", buy.get(i).book)));
//                        tmp.add(String.format("%d@%.1f - %d@%.1f", buy.get(i).volume, buy.get(i).price,
//                                sell.get(j).volume, sell.get(j).price));
//                        resultBook.put(buy.get(i).book, tmp);
//                        sell.remove(j);
//                        break;
//                    }
//                }
//            }
//        }
//        for (List<String> list : resultBook.values()) {
//            for (String s : list) {
//                System.out.println(s);
//            }
//        }
    }
}


