package ru.job4j.orderbook;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Task TO DO
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class ParserTest {
    @Test
    public void test() throws Exception {

        Parser parser = new Parser();
        parser.fillOrders("/home/malamut/orders_orig.xml");

    }

}