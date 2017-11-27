package ru.job4j.pamperingwithdb;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Task XML XSLT JDBC optimization.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.11.2017
 */

public class Calculate {
    /**
     * Children entry.
     */
    private static final String ENTRY = "entry";
    /**
     * Childre entry.
     */
    private static final String FIELD = "field";
    /**
     * Result of the summation.
     */
    private int result;

    /**
     * Method parse XML and calculate sum.
     *
     * @param path path to file.
     * @return int.
     * @throws XMLStreamException    exception.
     * @throws FileNotFoundException exception.
     */
    public int calc(String path) throws XMLStreamException, FileNotFoundException {

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(path));
        while (reader.hasNext()) {
            reader.next();
            if (reader.isStartElement()) {
                if (ENTRY.equals(reader.getLocalName())) {
                    int tmp = Integer.parseInt(reader.getAttributeValue(null, FIELD));
                    result = result + tmp;
                }
            }
        }
        return result;
    }
}
