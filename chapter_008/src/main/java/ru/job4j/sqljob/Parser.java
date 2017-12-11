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
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.sql.*;
import java.util.List;

public class Parser {

    public void grab() {
        Document document = null;
        try {
            document = Jsoup.connect("http://www.sql.ru/forum/job/1").userAgent("Mozilla").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Elements elements = document.getElementsByClass("postslisttopic");
        Elements elements = document.getElementsByClass("altCol");
        for (Element element : elements) {
//            System.out.println(element.getElementsByAttribute("href").get(0).attr("href"));
            System.out.println(element);

        }
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