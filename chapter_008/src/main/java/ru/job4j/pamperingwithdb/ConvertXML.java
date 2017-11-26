package ru.job4j.pamperingwithdb;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Task XML XSLT JDBC optimization.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.11.2017
 */

public class ConvertXML {
    /**
     * Method convert xml from one view to another through xslt.
     *
     * @throws TransformerException exception.
     */
    public void convert() throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(System.getProperty("user.dir") + "/Style.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new File(System.getProperty("user.dir") + "/1.xml"));
        transformer.transform(text, new StreamResult(new File(System.getProperty("user.dir") + "/2.xml")));
    }
}
