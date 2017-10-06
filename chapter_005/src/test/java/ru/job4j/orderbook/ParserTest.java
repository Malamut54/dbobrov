package ru.job4j.orderbook;

import org.junit.Test;

import java.util.Date;

/**
 * Task Order Book.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class ParserTest {
    /**
     * Execution time measurement.
     *
     * @throws Exception exception.
     */
    @Test
    public void test() throws Exception {
        Main book = new Main();
        Date start = new Date();
        book.formBook("/home/malamut/orders_orig.xml"); //HDD
        Date finish = new Date();
        System.out.println((finish.getTime() - start.getTime()) + " ms");
    }

}