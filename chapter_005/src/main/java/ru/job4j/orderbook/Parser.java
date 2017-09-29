package ru.job4j.orderbook;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Task Order Book.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class Parser {
    /**
     * Add Order.
     */
    private static final String ADD = "AddOrder";
    /**
     * Delete Order.
     */
    private static final String DEL = "DeleteOrder";
    /**
     * ID order/
     */
    private static final String ID = "orderId";
    /**
     * Number of book.
     */
    private static final String BOOK = "book";
    /**
     * Operation(Sell or Buy).
     */
    private static final String OPER = "operation";
    /**
     * Price.
     */
    private static final String PRICE = "price";
    /**
     * Volume.
     */
    private static final String VOLUME = "volume";
    /**
     * Store order by id.
     */
    private Map<Integer, Order> mapOrder = new HashMap<>();

    /**
     * Parser. Add and remove order.
     *
     * @param file input file.
     * @return Map.
     * @throws XMLStreamException    exception.
     * @throws FileNotFoundException exception.
     */
    Map fillOrders(String file) throws XMLStreamException, FileNotFoundException {

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));
        while (reader.hasNext()) {
            reader.next();
            if (reader.isStartElement()) {
                if (ADD.equals(reader.getLocalName())) {


                    Integer id = Integer.parseInt(reader.getAttributeValue(null, ID));
                    int book = Integer.parseInt(reader.getAttributeValue(null, BOOK).substring(5));
                    String operation = reader.getAttributeValue(null, OPER);
                    float price = Float.parseFloat(reader.getAttributeValue(null, PRICE));
                    int volume = Integer.parseInt(reader.getAttributeValue(null, VOLUME));

                    mapOrder.put(id, new Order(book, operation, price, volume));

                } else if (DEL.equals(reader.getLocalName())) {
                    Integer id = Integer.parseInt(reader.getAttributeValue(null, ID));
                    mapOrder.remove(id);
                }
            }
        }
        return mapOrder;
    }
}
