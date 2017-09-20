package ru.job4j.orderbook;

import java.util.*;

/**
 * Task TO DO
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class Book {
    private List<Order> sell = new ArrayList<>();
    private List<Order> buy = new ArrayList<>();


    void divideOnOperation(Map<Integer, Order> orders) {
        for (Order order : orders.values()) {
            if (order.operation.equals("SELL")) {
                sell.add(order);
            } else {
                buy.add(order);
            }
        }
    }

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
                    sellTmp.set(j, new Order(sell.get(i).book, "SELL", sell.get(i).price, sell.get(i).volume + sellTmp.get(j).volume));
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
                    buyTmp.set(j, new Order(buy.get(i).book, "BUY", buy.get(i).price, buy.get(i).volume + buyTmp.get(j).volume));
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
                if (buy.get(i).price >= sell.get(j).price && buy.get(i).book == sell.get(j).book) {

                    int volume = buy.get(i).volume - sell.get(j).volume;

                    if (volume > 0) {
                        buy.set(i, new Order(buy.get(i).book, "BUY", buy.get(i).price, volume));
                        sell.remove(j);

                    } else if (volume < 0) {
                        sell.set(j, new Order(sell.get(j).book, "SELL", sell.get(j).price, Math.abs(volume)));
                        buy.remove(i);

                    } else {
                        buy.remove(i);
                        sell.remove(j);
                    }
                }
            }
        }
        System.out.println(buy);
        System.out.println(sell);




    }

}


