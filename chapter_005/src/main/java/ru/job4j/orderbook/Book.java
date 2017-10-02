package ru.job4j.orderbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Task Order Book.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class Book {
    /**
     * Operation SELL.
     */
    private static final String SELL = "SELL";
    /**
     * Operation BUY.
     */
    private static final String BUY = "BUY";
    /**
     * Order sell.
     */
    private List<Order> sell = new ArrayList<>();
    /**
     * Order bid.
     */
    private List<Order> buy = new ArrayList<>();

    /**
     * Getter for sell.
     *
     * @return List.
     */
    public List<Order> getSell() {
        return sell;
    }

    /**
     * Getter for buy.
     * @return List.
     */
    public List<Order> getBuy() {
        return buy;
    }

    /**
     * Divide by operation (sell or buy).
     * @param orders mixed map.
     */
    void divideOnOperation(Map<Integer, Order> orders) {
        for (Order order : orders.values()) {
            if (SELL.equals(order.operation)) {
                sell.add(order);
            } else {
                buy.add(order);
            }
        }
    }

    /**
     * summ volume by price.
     */
    void sumVolume() {
        List<Order> sellTmp = new ArrayList<>();
        List<Order> buyTmp = new ArrayList<>();

        if (sellTmp.size() == 0 && buyTmp.size() == 0) {
            sellTmp.add(sell.get(0));
            sell.remove(0);
            buyTmp.add(buy.get(0));
            buy.remove(0);
        }

        for (int i = 0; i < sell.size(); i++) {
            for (int j = 0; j < sellTmp.size(); j++) {
                if (sell.get(i).book == sellTmp.get(j).book && sell.get(i).price == sellTmp.get(j).price) {
                    sellTmp.set(j, new Order(sell.get(i).book, SELL, sell.get(i).price, sell.get(i).volume + sellTmp.get(j).volume));
                    break;
                } else if (j == sellTmp.size() - 1) {
                    sellTmp.add(sell.get(i));
                    break;
                }
            }
        }

        for (int i = 0; i < buy.size(); i++) {
            for (int j = 0; j < buyTmp.size(); j++) {
                if (buy.get(i).book == buyTmp.get(j).book && buy.get(i).price == buyTmp.get(j).price) {
                    buyTmp.set(j, new Order(buy.get(i).book, BUY, buy.get(i).price, buy.get(i).volume + buyTmp.get(j).volume));
                    break;
                } else if (j == buyTmp.size() - 1) {
                    buyTmp.add(buy.get(i));
                    break;
                }
            }
        }
        this.sell = sellTmp;
        this.buy = buyTmp;

    }

    /**
     * Main method for calculation Order Book.
     */
    void calcBook() {
        Set<Order> sellSort = new TreeSet<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {

                return Float.compare(o1.price, o2.price);
            }
        });
        Set<Order> buySort = new TreeSet<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Float.compare(o2.price, o1.price);
            }
        });

        sellSort.addAll(sell);
        buySort.addAll(buy);

        this.sell.clear();
        this.buy.clear();

        this.sell.addAll(sellSort);
        this.buy.addAll(buySort);

        for (int i = 0; i < buy.size(); i++) {
            for (int j = 0; j < sell.size(); j++) {
                if (buy.get(i).book != 0 && sell.get(j).book != 0 && buy.get(i).price >= sell.get(j).price && buy.get(i).book == sell.get(j).book) {

                    int volume = buy.get(i).volume - sell.get(j).volume;

                    if (volume > 0) {
                        buy.set(i, new Order(buy.get(i).book, BUY, buy.get(i).price, volume));
                        sell.set(j, new Order(0, SELL, 0, 0));

                    } else if (volume < 0) {
                        sell.set(j, new Order(sell.get(j).book, SELL, sell.get(j).price, Math.abs(volume)));
                        buy.set(i, new Order(0, BUY, 0, 0));

                    } else {
                        buy.set(i, new Order(0, BUY, 0, 0));
                        sell.set(j, new Order(0, SELL, 0, 0));
                    }
                }
            }
        }
        Iterator<Order> iterBuy = buy.iterator();
        Iterator<Order> iterSell = sell.iterator();

        while (iterBuy.hasNext()) {
            if (iterBuy.next().book == 0) {
                iterBuy.remove();
            }
        }
        while (iterSell.hasNext()) {
            if (iterSell.next().book == 0) {
                iterSell.remove();
            }
        }
    }
}


