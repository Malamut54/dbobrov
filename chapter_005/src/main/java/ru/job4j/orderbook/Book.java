package ru.job4j.orderbook;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Task Order Book.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class Book {
    private final String operSell = "SELL";
    private final String operBuy = "BUY";
    private Map<Float, Integer> sell = new TreeMap<>();
    private Map<Float, Integer> buy = new TreeMap<>(new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return Float.compare(o2, o1);
        }
    });

    public void splitByOperation(List<Order> list) {

        Iterator<Map.Entry<Float, Integer>> buyIt = buy.entrySet().iterator();
        Iterator<Map.Entry<Float, Integer>> sellIt = sell.entrySet().iterator();

        for (Order order : list) {
            if (order.operation.equals(operBuy)) {
                if (buy.containsKey(order.price)) {
                    buy.put(order.price, buy.get(order.price) + order.volume);
                } else {
                    buy.put(order.price, order.volume);
                }
            } else if (order.operation.equals(operSell)) {
                if (sell.containsKey(order.price)) {
                    sell.put(order.price, sell.get(order.price) + order.volume);
                } else {
                    sell.put(order.price, order.volume);
                }
            }
        }
        for (Map.Entry<Float, Integer> entryBuy : buy.entrySet()) {
            for (Map.Entry<Float, Integer> entrySell : sell.entrySet()) {
                if (entryBuy.getKey() >= entrySell.getKey()) {
                    int volume = entryBuy.getValue() - entrySell.getValue();

                    if (volume > 0) {
                        entryBuy.setValue(volume);
                        entrySell.setValue(0);
                    } else if (volume < 0) {
                        entrySell.setValue(Math.abs(volume));
                        entryBuy.setValue(0);
                    } else {
                        entrySell.setValue(0);
                        entryBuy.setValue(0);
                    }

                }
            }
        }

        while (buyIt.hasNext()) {
            Map.Entry<Float, Integer> entry = buyIt.next();
            if (entry.getValue() == 0) {
                buyIt.remove();
            }
        }
        while (sellIt.hasNext()) {
            Map.Entry<Float, Integer> entry = sellIt.next();
            if (entry.getValue() == 0) {
                sellIt.remove();
            }
        }
    }
}



