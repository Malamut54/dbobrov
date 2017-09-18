package ru.job4j.orderbook;

import org.junit.Test;

/**
 * Task TO DO
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class ParserTest {
    @Test
    public void test() throws Exception {

        Parser parser = new Parser();
//        parser.fillOrders("/home/malamut/orders_orig.xml");
        parser.fillOrders("C:\\Users\\kvazimoda\\Downloads\\orders.xml"); //SSD
//        parser.fillOrders("H:\\orders.xml"); //HDD

    }

}