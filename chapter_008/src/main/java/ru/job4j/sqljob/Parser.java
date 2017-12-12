package ru.job4j.sqljob;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.lang.annotation.Documented;
import java.sql.*;
import java.util.List;

public class Parser {

    public void grabLinkVacation() {
        int page = 1;
        try {
            Document document = Jsoup.connect(String.format("http://www.sql.ru/forum/job/%d)", page++)).userAgent("Mozilla").get();
            Elements elements = document.getElementsByAttributeValue("class", "postslisttopic");
            ;
            for (Element element : elements) {
                String urlVacancy = (element.child(0).attr("href"));
                if (checkDateVacancy(urlVacancy)) {
                    checkOnlyJavaVacancy(urlVacancy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void checkOnlyJavaVacancy(String link) {

        if (link.contains("java") && !link.contains("javascript") && !link.contains("java-script")) {

        }

    }

    public boolean checkDateVacancy(String link) {
        boolean result = false;
        try {
            Document document = Jsoup.connect(link).userAgent("Mozilla").get();
            Elements elements = document.select("td.msgFooter");

            String node = elements.first().childNode(0).toString().substring(0, 10);
            System.out.println(node);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

//    public boolean isFirstLaunch() {
//        boolean result = false;
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        String URL = "jdbc:postgresql://127.0.0.1:5432/sqlru";
//        String user = "sqlru";
//        String password = "12345678";
//
//        try {
//            connection = DriverManager.getConnection(URL, user, password);
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT id FROM sqljob WHERE id = 1");
//            result = resultSet.next();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                resultSet.close();
//                statement.close();
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return result;
//    }
}