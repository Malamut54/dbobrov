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
    /**
     * Operation sell.
     */
    private final String operSell = "SELL";
    /**
     * Operation buy.
     */
    private final String operBuy = "BUY";
    /**
     * Store price and volume for sell.
     */
    private Map<Float, Integer> sell = new TreeMap<>();
    /**
     * Store price and volume for buy.
     */
    private Map<Float, Integer> buy = new TreeMap<>(new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return Float.compare(o2, o1);
        }
    });

    /**
     * Getter for sell.
     *
     * @return sell.
     */
    public Map<Float, Integer> getSell() {
        return sell;
    }

    /**
     * Getter for buy.
     * @return
     */
    public Map<Float, Integer> getBuy() {
        return buy;
    }

    /**
     * Form sell and buy for concrete book.
     * @param list Orders.
     */
    public void formLadder(List<Order> list) {

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

        Iterator<Map.Entry<Float, Integer>> buyIt = buy.entrySet().iterator();
        Iterator<Map.Entry<Float, Integer>> sellIt = sell.entrySet().iterator();

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



