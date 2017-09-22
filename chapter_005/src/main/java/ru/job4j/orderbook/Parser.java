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
                if (reader.getLocalName().equals("AddOrder")) {

                    Integer id = Integer.parseInt(reader.getAttributeValue(4));
                    int book = Integer.parseInt(reader.getAttributeValue(0).substring(5));
                    String operation = reader.getAttributeValue(1);
                    float price = Float.parseFloat(reader.getAttributeValue(2));
                    int volume = Integer.parseInt(reader.getAttributeValue(3));

                    mapOrder.put(id, new Order(book, operation, price, volume));

                } else if (reader.getLocalName().equals("DeleteOrder")) {
                    Integer id = Integer.parseInt(reader.getAttributeValue(1));
                    mapOrder.remove(id);
                }
            }
        }
        return mapOrder;
    }
}
