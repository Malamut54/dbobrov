package ru.job4j.orderbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    void summVolume() {
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

}


