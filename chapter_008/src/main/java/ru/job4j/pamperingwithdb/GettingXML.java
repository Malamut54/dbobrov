package ru.job4j.pamperingwithdb;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Task XML XSLT JDBC optimization.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.11.2017
 */
public class GettingXML {
    /**
     * Method generate xml from database.
     *
     * @param init number of value and path to db.
     * @throws ParserConfigurationException exception.
     * @throws TransformerException         exception.
     * @throws FileNotFoundException        exception.
     */
    public void createXML(Init init) throws ParserConfigurationException, TransformerException, FileNotFoundException {
        String urlToDB = init.getConnectToDB();
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element entries = document.createElement("entries");
        document.appendChild(entries);

        try {
            conn = DriverManager.getConnection(urlToDB);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT FIELD FROM test");
            while (rs.next()) {
                Element entry = document.createElement("entry");
                Element field = document.createElement("field");
                entries.appendChild(entry);
                entry.appendChild(field);
                Text text = document.createTextNode(String.format("%d", (rs.getInt("FIELD"))));
                field.appendChild(text);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        //Create xml.
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream(System.getProperty("user.dir") + "/1.xml")));
    }
}
