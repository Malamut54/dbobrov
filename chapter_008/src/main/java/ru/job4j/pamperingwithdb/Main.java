package ru.job4j.pamperingwithdb;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

/**
 * Task XML XSLT JDBC optimization.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.11.2017
 */

public class Main {
    /**
     * Main method that starts the application.
     *
     * @param args input args.
     * @throws FileNotFoundException        exception.
     * @throws TransformerException         exception.
     * @throws ParserConfigurationException exception.
     * @throws XMLStreamException           exception.
     */
    public static void main(String[] args) throws FileNotFoundException, TransformerException, ParserConfigurationException, XMLStreamException {
        Init init = new Init();

        init.setNumber(1000000);
        init.setConnectToDB("jdbc:sqlite:H:\\projects\\sqlLiteDB\\base.db");
//        init.setConnectToDB("jdbc:sqlite:/home/malamut/testDB.db");
        FillDB fill = new FillDB();
        ConvertXML convertXML = new ConvertXML();
        GettingXML gettingXML = new GettingXML();
        Calculate calculate = new Calculate();
        fill.fillDataBase(init);
        gettingXML.createXML(init);
        convertXML.convert();
        System.out.println(calculate.calc("2.xml"));


    }
}
